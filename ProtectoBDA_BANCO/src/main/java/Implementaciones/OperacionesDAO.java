

package Implementaciones;

// Importaciones
import Implementaciones.*;
import Dominio.Operacion;
import Dominio.Transferencia;
import Excepciones.PersistenciaException;
import Interfaces.IConexionBD;
import Interfaces.IConexionBD;
import Interfaces.IOperacionesDAO;
import Interfaces.IOperacionesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase permite implementar los métodos para generar y realizar
 * Operaciones.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926
 * 18/02/2023 01:46:55 PM
 */
public class OperacionesDAO implements IOperacionesDAO {
    
    private static final Logger LOG = Logger.getLogger(OperacionesDAO.class.getName());
    public final IConexionBD MANEJADOR_CONEXIONES;

    public OperacionesDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    @Override
    public Operacion consultar(Integer folio) {
        String consulta = "SELECT folio, fecha, monto, num_cuenta_origen"
                + " FROM operaciones WHERE folio = ?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, folio);
            ResultSet resultado = comando.executeQuery();
            Operacion operacion = null;
            if (resultado.next()) {
                Integer folioOperacion = resultado.getInt("folio");
                String fecha = resultado.getString("fecha");
                Float monto = resultado.getFloat("monto");
                Integer numCuentaOrigen = resultado.getInt("num_cuenta_origen");
                operacion = new Operacion(folioOperacion, fecha, monto, numCuentaOrigen);
            }
            return operacion;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Operacion insertar(Operacion operacion) throws PersistenciaException {
        String insercion = "INSERT INTO Operaciones (monto, num_cuenta_origen)"
                + " VALUES (?, ?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(insercion, Statement.RETURN_GENERATED_KEYS);) {
            // INSERTAR
            comando.setFloat(1, operacion.getMonto_pesos());
            comando.setInt(2, operacion.getNum_cuenta_origen());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                // CONSULTAR ID Y FECHA
                Integer llavePrimaria = llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS);
                String fechaOperacion = llavesGeneradas.getNString("fecha");
                operacion.setFolio(llavePrimaria);
                operacion.setFecha_hora(fechaOperacion);
                return operacion;
            }
            LOG.log(Level.WARNING, "Se inserto la operacion pero no se generó folio.");
            throw new PersistenciaException("Se inserto la operacion pero no se generó folio.");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar al operacion: " + ex.getMessage());
        }
    }
}

package Implementaciones;

// Importaciones
import Interfaces.IOperacionesDAO;
import Interfaces.IConexionBD;
import Dominio.Operacion;
import Excepciones.PersistenciaException;
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
 * @author Joel Antonio Lopez Cota ID: 00000228926 18/02/2023 01:46:55 PM
 */
public class OperacionesDAO implements IOperacionesDAO {

    // Atributos
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    public final IConexionBD MANEJADOR_CONEXIONES;

    /**
     * Constructor que crea y maneja la conexión a la base de datos
     *
     * @param manejadorConexiones Manejador de conexiones
     */
    public OperacionesDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    /**
     * Metodo que permite consultar una operacion en la base de datos
     *
     * @param folio es el folio que permite consultar la operacion
     * @return el objeto operacion con todos sus atributos
     */
    @Override
    public Operacion consultar(Integer folio) {
        String consulta = "SELECT folio, fecha, monto, num_cuenta_origen,tipo"
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
                String tipoTransaccion = resultado.getString("tipo");
                operacion = new Operacion(folioOperacion, fecha, monto, numCuentaOrigen, tipoTransaccion);
            }
            return operacion;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo que permite insertar una operacion en la base de datos
     *
     * @param operacion es la operacion que se desea insertar
     * @return el objeto operacion con sus atributos insertados
     * @throws PersistenciaException
     */
    @Override
    public Operacion insertar(Operacion operacion) throws PersistenciaException {
        String insercion = "INSERT INTO Operaciones (monto, num_cuenta_origen,tipo)"
                + " VALUES (?, ?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(insercion, Statement.RETURN_GENERATED_KEYS);) {
            // INSERTAR
            comando.setFloat(1, operacion.getMonto_pesos());
            comando.setInt(2, operacion.getNum_cuenta_origen());
            comando.setString(3, operacion.getTipoTransaccion());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                // CONSULTAR ID 
                Integer llavePrimaria = llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS);
                operacion.setFolio(llavePrimaria);
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

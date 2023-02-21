/**
 * TransferenciasDAO.java
 */
package Implementaciones;

// Importaciones
import Dominio.Cliente;
import Dominio.Cuenta;
import Dominio.Operacion;
import Dominio.Transferencia;
import Excepciones.PersistenciaException;
import Interfaces.IConexionBD;
import Interfaces.ITransferenciasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase permite implementar los métodos para generar y realizar
 * Transferencias.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 18/02/2023 01:46:55 PM
 */
public class TransferenciasDAO implements ITransferenciasDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    public final IConexionBD MANEJADOR_CONEXIONES;

    public TransferenciasDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    @Override
    public Transferencia insertar(Transferencia transferencia) throws PersistenciaException {
        String codigoSQL = "INSERT INTO Transferencias (folio, num_cuenta_destino)"
                + " VALUES (?, ?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            // INSERTAR
            comando.setInt(1, transferencia.getFolio());
            comando.setInt(2, transferencia.getNum_cuenta_destino());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                // CONSULTAR ID
                Integer llavePrimaria = llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS);
                transferencia.setId_transferencia(llavePrimaria);
                return transferencia;
            }
            LOG.log(Level.WARNING, "Se inserto la transferencia pero no se generó ID.");
            throw new PersistenciaException("Se inserto la transferencia pero no se generó ID.");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar la transferencia: " + ex.getMessage());
        }
    }

    @Override
    public Transferencia consultar(Integer id_transferencia) {
        String consulta = "SELECT id_transferencia, folio, num_cuenta_destino"
                + " FROM transferencias WHERE id_transferencia = ?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, id_transferencia);
            ResultSet resultado = comando.executeQuery();
            Transferencia transferencia = null;
            if (resultado.next()) {
                Integer idTransferencia = resultado.getInt("id_transferencia");
                Integer folio = resultado.getInt("folio");
                Integer num_cuenta_destino = resultado.getInt("num_cuenta_destino");
                transferencia = new Transferencia(idTransferencia, folio, num_cuenta_destino);
            }
            return transferencia;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer realizarTransferencia(Transferencia transferencia,Operacion operacion) throws PersistenciaException {
            String transaccion = "START TRANSACTION;\n"
                    + " UPDATE cuentas SET saldo = saldo - ? WHERE num_cuenta = ?;\n" // Cuenta origen
                    + " UPDATE cuentas SET saldo = saldo + ? WHERE num_cuenta = ?;\n" // Cuenta destino
                    + " COMMIT;";
            try (
                    Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(transaccion);) {
                comando.setFloat(1, operacion.getMonto_pesos());
                comando.setInt(2, operacion.getNum_cuenta_origen());
                comando.setFloat(3, operacion.getMonto_pesos());
                comando.setInt(4, transferencia.getNum_cuenta_destino());
                ResultSet resultado = comando.executeQuery();
                return 6; // Se realizó la transferencia exitosamente 
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage());
                return -1; // No se pudo realizar la transferencia
            }
        } 
    }


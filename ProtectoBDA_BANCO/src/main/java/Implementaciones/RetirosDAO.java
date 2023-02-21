package implementaciones;

import Implementaciones.OperacionesDAO;
import Interfaces.IConexionBD;
import Dominio.Retiro;
import Excepciones.PersistenciaException;
import Interfaces.IRetirosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase permite implementar los métodos para generar y realizar
 * Retiros.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926
 * 18/02/2023 01:46:55 PM
 */
public class RetirosDAO implements IRetirosDAO {
    
    private static final Logger LOG = Logger.getLogger(OperacionesDAO.class.getName());
    public final IConexionBD MANEJADOR_CONEXIONES;

    public RetirosDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }
    
    @Override
    public Retiro insertar(Retiro retiro) throws PersistenciaException {
     String codigoSQL = "INSERT INTO Retiros (folio)"
                + " VALUES (?)";
      try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
         comando.setInt(1, retiro.getFolio());
         comando.executeUpdate();
         ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS);
                retiro.setId_retiro(llavePrimaria);
                return retiro;
            }    
            LOG.log(Level.WARNING, "Se inserto el retiro pero no se generó ID.");
            throw new PersistenciaException("Se inserto el retiero pero no se generó ID.");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar el retiro: " + ex.getMessage());
        }
    }

    @Override
    public Retiro consultar(Integer id_retiro) throws PersistenciaException {
       String codigoSQL = "SELECT id_retiro,aes_decrypt(contrasena,'hunter2'),estado,folio FROM "
               + "Retiros WHERE id_retiro = ?";
       try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setInt(1, id_retiro);
           ResultSet resultado = comando.executeQuery();
           Retiro retiro = null;
           if (resultado.next()) {
               Integer idRetiro = resultado.getInt("id_retiro");
               Integer contrasena = resultado.getInt("aes_decrypt(contraseña,'hunter2')");
               String estado = resultado.getString("estado");
               Integer folio = resultado.getInt("folio");
               retiro = new Retiro(idRetiro, contrasena, estado, folio);
               return retiro;
           }
           throw new PersistenciaException("La cuenta no existe");
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    @Override
    public void actualizarRetiro(Integer id_retiro, Integer num_cuenta_origen, Float monto) throws PersistenciaException {
       String codigoSQL = "CALL realizarRetiro(?,?,?)";
       try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setInt(1, id_retiro);
           comando.setInt(2, num_cuenta_origen);
           comando.setFloat(3, monto);
           comando.executeUpdate();
       } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible realizar el retiro.");
        }     

    }

    @Override
    public void cancelarPorTiempoRetiro(Integer id_retiro) throws PersistenciaException {
      String codigoSQL = "CALL retiroNoCobrado(?)";
      try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
          comando.setInt(1, id_retiro);
          comando.executeUpdate();
      }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue consultar el estado");
        }  
    }
}
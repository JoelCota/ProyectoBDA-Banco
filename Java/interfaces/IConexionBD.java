
package interfaces;

import java.sql.Connection;
import java.sql.SQLException;


public interface IConexionBD {
  Connection crearConexiones() throws SQLException;  
}

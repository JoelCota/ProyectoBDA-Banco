
package Interfaces;

import java.sql.Connection;
import java.sql.SQLException;
/**
* @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 */
public interface IConexionBD {
  Connection crearConexiones() throws SQLException;  
}

/**
 * IConexionBD.java
 */

package Interfaces;

// Importaciones
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Esta clase permite implementar una interface de tipo ConexionBD.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 * 15/02/2023 01:12:13 PM
 */
public interface IConexionBD {
    
    Connection crearConexion() throws SQLException;
}

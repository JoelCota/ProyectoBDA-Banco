/**
 * ConexionBD.java
 */
package Implementaciones;

// Importaciones
import Interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase permite crear la conexion con la base de datos.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926
 */
public class ConexionBD implements IConexionBD {

    // Atributos
    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;

    /**
     * Constructor que crea y maneja la conexión a la base de datos.
     *
     * @param cadenaConexion Cadena de conexion al servidor
     * @param usuario Usuario
     * @param password Contraseña
     */
    public ConexionBD(String cadenaConexion, String usuario, String password) {
        this.CADENA_CONEXION = cadenaConexion;
        this.USUARIO = usuario;
        this.PASSWORD = password;
    }

    /**
     * Crea la conexion a la base de datos.
     *
     * @return Conexion con la base de datos.
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }
}

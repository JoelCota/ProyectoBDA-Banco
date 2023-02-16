
package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD implements IConexionBD{
    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;

    public ConexionBD(String cadenaConexion, String usuario, String password) {
        this.CADENA_CONEXION = cadenaConexion;
        this.USUARIO = usuario;
        this.PASSWORD = password;
    }
    
    @Override
    public Connection crearConexiones() throws SQLException {
          Connection conexion=DriverManager.getConnection(CADENA_CONEXION,USUARIO,PASSWORD);
          return conexion;
    }
    
}

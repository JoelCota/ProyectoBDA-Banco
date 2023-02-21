/**
 * CuentasDAO.java
 */

package Implementaciones;

// Importaciones
import Dominio.Cuenta;
import Dominio.Operacion;
import Interfaces.IConexionBD;
import Interfaces.ICuentasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Esta clase permite implementar los métodos para acceder y consultar a los datos
 * de Cuentas.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 
 * 26/01/2023 01:46:55 PM
 */
public class CuentasDAO implements ICuentasDAO {
    
    public final IConexionBD MANEJADOR_CONEXIONES;

    public CuentasDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    @Override
    public Cuenta consultar(Integer num_cuenta) {
        String consulta = "SELECT num_cuenta, fecha_apertura, saldo, estado, id_cliente"
                + " FROM cuentas WHERE num_cuenta = ?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, num_cuenta);
            ResultSet resultado = comando.executeQuery();
            Cuenta cuenta = null;
            if (resultado.next()) {
                Integer numCuenta = resultado.getInt("num_cuenta");
                String fecha_apertura = resultado.getString("fecha_apertura");
                Float saldo = resultado.getFloat("saldo"); 
                String estado = resultado.getString("estado");
                Integer id_cliente = resultado.getInt("id_cliente");
                cuenta = new Cuenta(num_cuenta, fecha_apertura, saldo, estado, id_cliente);
            }
            return cuenta;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}

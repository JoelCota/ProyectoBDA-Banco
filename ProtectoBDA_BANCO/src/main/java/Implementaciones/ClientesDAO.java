/**
 * ClientesDAO.java
 */
package Implementaciones;

// Importaciones
import Interfaces.IConexionBD;
import Interfaces.IClientesDAO;
import Dominio.Cliente;
import Dominio.Cuenta;
import Dominio.Domicilio;
import Excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 * Esta clase permite implementar los métodos para acceder y consultar a los datos
 * de Clientes.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 */
public class ClientesDAO implements IClientesDAO {

    // Atributos
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    public final IConexionBD MANEJADOR_CONEXIONES;

    /**
    * Constructor que crea y maneja la conexión a la base de datos
    * 
    * @param manejadorConexiones Manejador de conexiones
    */
    public ClientesDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    @Override
    public Cliente consultar(Integer id_cliente) {
        String consulta = "SELECT id_cliente,nombres,apellido_paterno,apellido_materno,fecha_nacimiento,edad,id_domicilio"
                + " FROM clientes WHERE id_cliente = ?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, id_cliente);
            ResultSet resultado = comando.executeQuery();
            Cliente cliente = null;
            if (resultado.next()) {
                Integer idCliente = resultado.getInt("id_cliente");
                String nombres = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                String fecha_nacimiento = resultado.getString("fecha_nacimiento");
                Integer edad = resultado.getInt("edad");
                Integer id_domicilio = resultado.getInt("id_domicilio");
                cliente = new Cliente(idCliente, nombres, apellidoPaterno, apellidoMaterno, fecha_nacimiento, edad, id_domicilio);
            }
            return cliente;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Cliente iniciarSesion(Integer id_cliente, String contrasena) {
        String consulta = "SELECT id_cliente,nombres,apellido_paterno,apellido_materno,fecha_nacimiento,aes_decrypt(contrasena,'hunter2'),edad,id_domicilio"
                + " FROM clientes WHERE id_cliente = ? and ? = aes_decrypt(contrasena,'hunter2')";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, id_cliente);
            comando.setString(2, contrasena);
            ResultSet resultado = comando.executeQuery();
            Cliente cliente = null;
            if (resultado.next()) {
                Integer idCliente = resultado.getInt("id_cliente");
                String nombres = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                String fecha_nacimiento = resultado.getString("fecha_nacimiento");
                Integer edad = resultado.getInt("edad");
                Integer id_domicilio = resultado.getInt("id_domicilio");
                String contrasenaCliente = resultado.getString("aes_decrypt(contrasena,'hunter2')");
                cliente = new Cliente(idCliente, nombres, apellidoPaterno, apellidoMaterno, fecha_nacimiento, edad, contrasenaCliente, id_domicilio);
            }
            return cliente;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Método que permite insertar un cliente utilizando la información enviada
     * como parámetro. Deberá devolver el cliente guardado junto con el ID que
     * fue generado por la base de datos.
     *
     * @param cliente Cliente a insertar en la base de datos
     * @return Cliente guardado junto con la ID que se le fue generada
     * @throws PersistenciaException
     */
    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "INSERT INTO Clientes (nombres, apellido_paterno, apellido_materno, fecha_nacimiento, contrasena, id_domicilio)"
                + " VALUES (?, ?, ?, ?, aes_encrypt(?,\"hunter2\"), ?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            // INSERTAR
            comando.setString(1, cliente.getNombres().toUpperCase());
            comando.setString(2, cliente.getApellido_paterno().toUpperCase());
            comando.setString(3, cliente.getApellido_materno().toUpperCase());
            comando.setString(4, cliente.getFecha_nacimiento());
            comando.setString(5, cliente.getContrasena());
            comando.setInt(6, cliente.getId_domicilio());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                // CONSULTAR ID
                Integer llavePrimaria = llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS);
                cliente.setId_cliente(llavePrimaria);
                return cliente;
            }
            LOG.log(Level.WARNING, "Se inserto el cliente pero no se generó id.");
            throw new PersistenciaException("Se inserto el cliente pero no se generó id.");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar al cliente: " + ex.getMessage());
        }
    }


    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "UPDATE Clientes SET nombres=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, contrasena=? where id_cliente=?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cliente.getNombres().toUpperCase());
            comando.setString(2, cliente.getApellido_paterno().toUpperCase());
            comando.setString(3, cliente.getApellido_materno().toUpperCase());
            comando.setString(4, cliente.getFecha_nacimiento());
            comando.setString(5, cliente.getContrasena());
            comando.setInt(6, cliente.getId_cliente());
            comando.executeUpdate();
            if (comando.execute()) {
                return cliente;
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar al cliente: " + ex.getMessage());
        }
        return null;
    }


}

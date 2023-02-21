/**
 * ClientesDAO.java
 */
package Implementaciones;

// Importaciones
import Dominio.Cliente;
import Dominio.Cuenta;
import Dominio.Domicilio;
import Interfaces.IClientesDAO;
import Interfaces.IConexionBD;
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
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 
 * 26/01/2023 01:46:55 PM
 */
public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    public final IConexionBD MANEJADOR_CONEXIONES;

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
        String consulta = "SELECT id_cliente,nombres,apellido_paterno,apellido_materno,fecha_nacimiento,contrasena,edad,id_domicilio"
                + " FROM clientes WHERE id_cliente = ? and contrasena=?";
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
                String contrasenaCliente = resultado.getString("contrasena");
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
                + " VALUES (?, ?, ?, ?, ?, ?)";
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
    public Domicilio insertarDomicilio(Domicilio domicilio) throws PersistenciaException {
        String codigoSQL = "INSERT INTO domicilios (calle, numero, colonia)"
                + " VALUES (?, ?, ?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            // INSERTAR
            comando.setString(1, domicilio.getCalle().toUpperCase());
            comando.setString(2, domicilio.getNumero());
            comando.setString(3, domicilio.getColonia().toUpperCase());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                // CONSULTAR ID
                Integer llavePrimaria = llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS);
                domicilio.setId_domicilio(llavePrimaria);
                return domicilio;
            }
            LOG.log(Level.WARNING, "Se inserto el domicilio pero no se generó id.");
            throw new PersistenciaException("Se inserto el domicilio pero no se generó id.");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar al domicilio: " + ex.getMessage());
        }
    }

    @Override
    public Domicilio actualizarDomicilio(Domicilio domicilio) throws PersistenciaException {
        String codigoSQL = "UPDATE domicilios set calle=?, numero=?, colonia=? where id_domicilio=?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            // INSERTAR
            comando.setString(1, domicilio.getCalle().toUpperCase());
            comando.setString(2, domicilio.getColonia().toUpperCase());
            comando.setString(3, domicilio.getNumero());
            comando.setInt(4, domicilio.getId_domicilio());
            comando.executeUpdate();
            if (comando.execute()) {
                return domicilio;
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar al domicilio: " + ex.getMessage());
        }
        return null;
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

    @Override
    public Domicilio consultarDomicilio(Integer id_domicilio) {
        String consulta = "SELECT id_domicilio,calle,numero,colonia from domicilios where id_domicilio=?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, id_domicilio);
            ResultSet resultado = comando.executeQuery();
            Domicilio domicilio = null;
            if (resultado.next()) {
                Integer idDomicilio = resultado.getInt("id_domicilio");
                String calle = resultado.getString("calle").toUpperCase();
                String numero = resultado.getString("numero");
                String colonia = resultado.getString("colonia").toUpperCase();
                domicilio = new Domicilio(idDomicilio, calle, numero, colonia);
            }
            return domicilio;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Cuenta insertarCuenta(Cuenta cuenta) throws PersistenciaException {
        String codigoSQL = "INSERT INTO cuentas (saldo,id_cliente)"
                + " VALUES (?, ?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            // INSERTAR
            comando.setFloat(1, cuenta.getSaldo());
            comando.setInt(2, cuenta.getId_cliente());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                // CONSULTAR ID
                Integer llavePrimaria = llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS);
                cuenta.setId_cliente(llavePrimaria);
                return cuenta;
            }
            LOG.log(Level.WARNING, "Se inserto la cuenta pero no se generó id.");
            throw new PersistenciaException("Se inserto la cuenta pero no se generó id.");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo insertar la cuenta: " + ex.getMessage());
        }
    }

    @Override
    public Cuenta cancelarCuenta(Cuenta cuenta) throws PersistenciaException {
        String codigoSQL = "UPDATE cuentas SET estado='Cancelada' where id_cliente=? and num_cuenta=?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, cuenta.getId_cliente());
            comando.setInt(2, cuenta.getNum_cuenta());
            comando.executeUpdate();
            if (comando.execute()) {
                return cuenta;
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo cancelar la cuenta: " + ex.getMessage());
        }
        return null;
    }

    // Límite y paginado
    @Override
    public List<Cuenta> consultarListaCuentas(ConfiguracionPaginado configPaginado, Cliente cliente) throws PersistenciaException {
        String codigoSQL = "Select num_cuenta,saldo,estado from cuentas where id_cliente=? order by estado";
        List<Cuenta> listaCuentas = new LinkedList();
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comandoBase = conexion.prepareStatement(codigoSQL);) {
            comandoBase.setInt(1, cliente.getId_cliente());
            ResultSet resultado = comandoBase.executeQuery();
            Cuenta cuenta = null;
            while (resultado.next()) {
                Integer num_cuenta = resultado.getInt("num_cuenta");
                Float saldo = resultado.getFloat("saldo");
                String estado = resultado.getString("estado");
                cuenta = new Cuenta(num_cuenta, saldo, estado);
                listaCuentas.add(cuenta);
            }
            return listaCuentas;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new PersistenciaException("Error al consultar la lista", ex);
        }
    }

    // Límite y paginado
    @Override
    public List<Cuenta> consultarListaCuentas(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "Select num_cuenta from cuentas where id_cliente=? and estado='Activa'";
        List<Cuenta> listaCuentas = new LinkedList();
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comandoBase = conexion.prepareStatement(codigoSQL);) {
            comandoBase.setInt(1, cliente.getId_cliente());
            ResultSet resultado = comandoBase.executeQuery();
            Cuenta cuenta = null;
            while (resultado.next()) {
                Integer num_cuenta = resultado.getInt("num_cuenta");
                cuenta = new Cuenta(num_cuenta);
                listaCuentas.add(cuenta);
            }
            return listaCuentas;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new PersistenciaException("Error al consultar la lista", ex);
        }
    }
}

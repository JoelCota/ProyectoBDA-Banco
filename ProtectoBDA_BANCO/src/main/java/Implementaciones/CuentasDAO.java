/**
 * CuentasDAO.java
 */
package Implementaciones;

// Importaciones
import Interfaces.IConexionBD;
import Interfaces.ICuentasDAO;
import Dominio.Cliente;
import Dominio.Cuenta;
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
 * Esta clase permite implementar los métodos para acceder y consultar a los
 * datos de Cuentas.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926
 */
public class CuentasDAO implements ICuentasDAO {

    // Atributos
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    public final IConexionBD MANEJADOR_CONEXIONES;

    /**
     * Constructor que crea y maneja la conexión a la base de datos
     *
     * @param manejadorConexiones Manejador de conexiones
     */
    public CuentasDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    /**
     * Metodo que permite consultar una cuenta por medio de su número
     *
     * @param num_cuenta numero de la cuenta que se desea consultar
     * @return la cuenta a consultar
     */
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

    /**
     * Metodo que permite insertar una cuenta en la base de datos
     *
     * @param cuenta es la cuenta que se desea insertar
     * @return una objeto del tipo cuenta con su id
     * @throws PersistenciaException
     */
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

    /**
     * Metodo que permite cancelar una cuenta
     *
     * @param cuenta es la cuenta que se desea cancelar
     * @return la cuenta cancelada
     * @throws PersistenciaException se lanza en caso de erro
     */
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
    /**
     * Metodo que permite consultar la lista de cuentas
     *
     * @param configPaginado la configuracion del paginado
     * @param cliente el cliente al que se desea consultar las cuentas
     * @return una lista con las cuentas del cliente
     * @throws PersistenciaException se lanza en caso de error
     */
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
    /**
     * Metodo que permite consultar la lsita de cuentas
     *
     * @param cliente es el cliente al que se le desea consultar las cuentas
     * @return una lista con las cuentas que tiene el cliente
     * @throws PersistenciaException se lanza en caso de error
     */
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

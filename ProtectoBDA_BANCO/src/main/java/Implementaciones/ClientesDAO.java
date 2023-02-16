package Implementaciones;

import Dominio.Cliente;
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

import Interfaces.IClientesDAO;
import Interfaces.IConexionBD;

public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public ClientesDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    @Override
    public Cliente consultar(Integer idCliente) {
        String codigoSQL = "select nombre,apellido_paterno"
                + ",apellido_materno,id_direcciones from clientes where id=?";

        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setInt(1, idCliente);

            ResultSet resultado = comando.executeQuery();
            Cliente cliente = null;
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                int idDireccion = resultado.getInt("id_direcciones");
                cliente = new Cliente(id, nombre, apellidoPaterno,apellidoMaterno, idDireccion);

            }
            return cliente;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "Insert into clientes"
                + "(nombre,apellido_paterno,apellido_materno,id_direcciones) values"
                + " (?,?,?,?)";

        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(
                        codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, cliente.getNombres());
            comando.setString(2, cliente.getApellido_paterno());
            comando.setString(3, cliente.getApellido_materno());
            comando.setInt(4, cliente.getId_domicilio());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                int posicionLlavePrimaria = 1;
                Integer llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
                cliente.setId_cliente(llavePrimaria);
                return cliente;
            }
            LOG.log(Level.WARNING, "Cliente registrado, pero id no genereado");
            throw new PersistenciaException("Cliente registrado, pero id no genereado");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible registrar cliente");
        }
    }

   
}

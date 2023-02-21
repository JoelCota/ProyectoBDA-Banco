/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Interfaces.IDomicilioDAO;
import Dominio.Domicilio;
import Excepciones.PersistenciaException;
import Interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aroco
 */
public class DomicilioDAO implements IDomicilioDAO{
      
  private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    public final IConexionBD MANEJADOR_CONEXIONES;

    public DomicilioDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
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
}

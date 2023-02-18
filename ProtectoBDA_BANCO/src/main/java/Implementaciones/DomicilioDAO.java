/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Dominio.Domicilio;
import Excepciones.PersistenciaException;
import Interfaces.IConexionBD;
import Interfaces.IDomicilioDAO;
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
public class DomicilioDAO implements IDomicilioDAO {
      
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private IConexionBD MANEJADOR_CONEXIONES;
    
    public DomicilioDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES=manejadorConexiones;
    }
    
    @Override
    public Domicilio insertar(Domicilio domicilio) throws PersistenciaException {
        String codigoSQL = "INSERT INTO domicilios (calle, numero, colonia)"
                         + " VALUES (?, ?, ?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            // INSERTAR
            comando.setString(1, domicilio.getCalle());
            comando.setString(2, domicilio.getColonia());
            comando.setString(3, domicilio.getNumero());
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import Dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joel Lopez
 */
public class CuentasDAO implements ICuentasDAO{
    
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public CuentasDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }
    
    @Override
    public Cuenta realizarTransaccion() {
       return null;
    }


    @Override
    public Cuenta realizarRetiroSinTarjeta() {
       return null;
    }
    /**
     * Metodo que cancela una cuenta poniendola en modo cancelado
     * @param num_cuenta es el numerod e cuenta que se queire cancelar
     * @return el numero de cuenta que se va a eliminar
     * @throws PersistenciaException 
     */
    @Override
    public Cuenta cancelarCuenta(int num_cuenta) throws PersistenciaException {
        try (Connection conexion = GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comandoBase = conexion.prepareStatement("Select num_cuenta from Clientes where codigo=?");){
            comandoBase.setInt(1, num_cuenta);
            ResultSet resultado = comandoBase.executeQuery();
            Cuenta cuenta = null;
            if (resultado.next()) {
                Integer numeroCuenta=resultado.getInt("num_cuenta");
                cuenta=new Cuenta(numeroCuenta);
            }
            PreparedStatement comando = conexion.prepareStatement("Update cuentas set estado='Cancelada' WHERE num_cuenta=?;");
            comando.setInt(1, num_cuenta);
            comando.executeUpdate();
            if (comando.executeUpdate() == 0) {
                return cuenta;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
}

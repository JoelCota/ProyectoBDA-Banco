/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

// Importaciones
import Dominio.Retiro;
import Excepciones.PersistenciaException;

/**
 *
 * @author 52644
 */
public interface IRetirosDAO {
    
    public Retiro insertar(Retiro retiro) throws PersistenciaException;

    public Retiro consultar(Integer id_retiro) throws PersistenciaException;

    public void actualizarRetiro(Integer id_retiro, Integer num_cuenta_origen, Float monto) throws PersistenciaException;

    public void cancelarPorTiempoRetiro(Integer id_retiro) throws PersistenciaException;
}

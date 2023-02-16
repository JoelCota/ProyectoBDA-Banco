/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Dominio.Cuenta;
import excepciones.PersistenciaException;

/**
 *
 * @author Joel Lopez
 */
public interface ICuentasDAO {
   Cuenta cancelarCuenta(int num_cuenta)throws PersistenciaException;
   Cuenta realizarTransaccion();
   Cuenta realizarRetiroSinTarjeta();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Dominio.Domicilio;
import Excepciones.PersistenciaException;

/**
 *
 * @author aroco
 */
public interface IDomicilioDAO {
     Domicilio consultarDomicilio(Integer id_domicilio);

    Domicilio insertarDomicilio(Domicilio domicilio) throws PersistenciaException;

    Domicilio actualizarDomicilio(Domicilio domicilio) throws PersistenciaException;

}

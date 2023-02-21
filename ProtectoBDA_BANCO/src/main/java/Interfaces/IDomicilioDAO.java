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

    /**
     * Metodo que permite consultar el domicilio de la base de datos
     * @param id_domicilio es el id con el que se consultara el domicilio
     * @return el domicilio que se consulto con sus atributos
     */
    Domicilio consultarDomicilio(Integer id_domicilio);

    /**
     * Metodo que permite insertar un domicilio 
     * @param domicilio es el domicilio a insertar
     * @return el domicilio insertado   
     * @throws PersistenciaException se lanza en caso de error
     */
    Domicilio insertarDomicilio(Domicilio domicilio) throws PersistenciaException;

    /**
     * Metodo que permite actualizar el domicilio
     * @param domicilio objeto domicilio con los valores que se van a actualizar
     * @return el domicilio con los datos ya actualizados
     * @throws PersistenciaException se lanza en caso de error
     */
    Domicilio actualizarDomicilio(Domicilio domicilio) throws PersistenciaException;

}

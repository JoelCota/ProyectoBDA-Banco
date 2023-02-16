
package Interfaces;

import Dominio.Cliente;
import Excepciones.PersistenciaException;


public interface IClientesDAO {
   Cliente consultar(Integer idCliente); 
   Cliente insertar(Cliente cliente) throws PersistenciaException;
}


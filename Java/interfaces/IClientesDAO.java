
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;


public interface IClientesDAO {
   Cliente consultar(Integer idCliente); 
   Cliente insertar(Cliente cliente) throws PersistenciaException;
}


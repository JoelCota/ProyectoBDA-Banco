/**
 * IClientesDAO.java
 */
package Interfaces;

// Importaciones
import Dominio.Cliente;
import Dominio.Domicilio;
import Excepciones.PersistenciaException;

/**
 * Esta clase permite implementar una interface de tipo ClientesDAO.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 15/02/2023 01:34:02 PM
 */
public interface IClientesDAO {

    Cliente consultar(Integer id_cliente);

    Cliente insertar(Cliente cliente) throws PersistenciaException;

    Cliente iniciarSesion(Integer id_cliente,String contrasena);

    Domicilio insertarDomicilio(Domicilio domicilio) throws PersistenciaException;
}

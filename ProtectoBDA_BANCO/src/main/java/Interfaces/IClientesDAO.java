/**
 * IClientesDAO.java
 */
package Interfaces;

// Importaciones
import Dominio.Cliente;
import Dominio.Cuenta;
import Dominio.Domicilio;
import Excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 * Esta clase permite implementar una interface de tipo ClientesDAO.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 
 * 15/02/2023 01:34:02 PM
 */
public interface IClientesDAO {
    /**
     * Metodo que permite consultar el cliente en base al id
     * @param id_cliente el id del cliente a consultar
     * @return un atributo de tipo cliente con los atributos del cliente consultado
     */
    Cliente consultar(Integer id_cliente);
    /**
     * Metodo que permite insertar un cliente en la base de datos
     * @param cliente es el cliente a insertar
     * @return un cliente inicializado con todos los atributos
     * @throws PersistenciaException Se genera en caso de error
     */
    Cliente insertar(Cliente cliente) throws PersistenciaException;
    /**
     * Metodo que permite iniciar sesion buscando los datos en la base de datos
     * @param id_cliente es el id del cliente a iniciar sesion
     * @param contrasena es la contraseña del cliente que desea iniciar sesion
     * @return el cliente formado con todos sus atributos
     */
    Cliente iniciarSesion(Integer id_cliente, String contrasena);
    /**
     * Metodo que permite actualizar el cliente en base a otro cliente
     * @param cliente es el atributo cliente que servira para actualizar los datos
     * @return el cliente con los datos actualizados
     * @throws PersistenciaException se genera en caso de error de persistencia
     */
    Cliente actualizarCliente(Cliente cliente) throws PersistenciaException;
}

/**
 * ICuentasDAO.java
 */
package Interfaces;

//Importaciones
import Dominio.Cliente;
import Dominio.Cuenta;
import Excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 * Esta clase permite implementar una interface de tipo CuentasDAO.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 15/02/2023 01:34:02 PM
 */
public interface ICuentasDAO {

    /**
     * Metodo que permite consular una cuenta en la base de datos en base al numero de cuenta
     * @param num_cuenta es el numero de cuenta a consultar
     * @return un objeto cuenta con los atributos del numero de cuenta del parametro
     */
    Cuenta consultar(Integer num_cuenta);

    /**
     * Metodo que permite consultar la lista de cuentas
     * @param configPaginado la configuracion del paginado
     * @param cliente el cliente al que se desea consultar las cuentas
     * @return una lista con las cuentas del cliente
     * @throws PersistenciaException se lanza en caso de error
     */
    List<Cuenta> consultarListaCuentas(ConfiguracionPaginado configPaginado, Cliente cliente) throws PersistenciaException;

    /**
     * Metodo que permite consultar la lsita de cuentas
     * @param cliente es el cliente al que se le desea consultar las cuentas
     * @return una lista con las cuentas que tiene el cliente
     * @throws PersistenciaException se lanza en caso de error
     */
    List<Cuenta> consultarListaCuentas(Cliente cliente) throws PersistenciaException;

    /**
     * Metodo que permite insertar una cuenta en la base de datos
     * @param cuenta es la cuenta que se desea insertar 
     * @return una objeto del tipo cuenta con su id
     * @throws PersistenciaException
     */
    Cuenta insertarCuenta(Cuenta cuenta) throws PersistenciaException;

    /**
     * Metodo que permite cancelar una cuenta
     * @param cuenta es la cuenta que se desea cancelar
     * @return la cuenta cancelada
     * @throws PersistenciaException se lanza en caso de erro
     */
    Cuenta cancelarCuenta(Cuenta cuenta) throws PersistenciaException;

}

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

    Cuenta consultar(Integer num_cuenta);

    List<Cuenta> consultarListaCuentas(ConfiguracionPaginado configPaginado, Cliente cliente) throws PersistenciaException;

    List<Cuenta> consultarListaCuentas(Cliente cliente) throws PersistenciaException;

    Cuenta insertarCuenta(Cuenta cuenta) throws PersistenciaException;

    Cuenta cancelarCuenta(Cuenta cuenta) throws PersistenciaException;

}

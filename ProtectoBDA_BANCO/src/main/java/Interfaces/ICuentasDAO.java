/**
 * ICuentasDAO.java
 */
package Interfaces;

//Importaciones
import Dominio.Cuenta;

/**
 * Esta clase permite implementar una interface de tipo CuentasDAO.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 
 * 15/02/2023 01:34:02 PM
 */
public interface ICuentasDAO {
    
    Cuenta consultar(Integer num_cuenta);
}

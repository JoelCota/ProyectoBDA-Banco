/**
 * IOperacionesDAO.java
 */

package Interfaces;

// Importaciones
import Dominio.Operacion;
import Dominio.Transferencia;
import Excepciones.PersistenciaException;


/**
 * Esta clase permite implementar una interface de tipo OperacionesDAO.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 
 * 19/02/2023 01:34:02 PM
 */
public interface IOperacionesDAO {
    
    Operacion consultar (Integer folio);
    
    Operacion insertar (Operacion operacion) throws PersistenciaException;
}

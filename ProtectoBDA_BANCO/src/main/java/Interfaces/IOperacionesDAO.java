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
    /**
    * Metodo que permite consultar una operacion en la base de datos
     * @param folio es el folio que permite consultar la operacion
     * @return el objeto operacion con todos sus atributos
     */
    Operacion consultar(Integer folio);
    /**
     * Metodo que permite insertar una operacion en la base de datos
     * @param operacion es la operacion que se desea insertar
     * @return el objeto operacion con sus atributos insertados
     * @throws PersistenciaException 
     */
    Operacion insertar(Operacion operacion) throws PersistenciaException;
}

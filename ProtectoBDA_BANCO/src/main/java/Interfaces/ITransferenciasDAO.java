/**
 * ITransferenciasDAO.java
 */

package Interfaces;

// Importaciones
import Dominio.Cuenta;
import Dominio.Transferencia;
import Excepciones.PersistenciaException;

/**
 * Esta clase permite implementar una interface de tipo TransferenciasDAO.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 
 * 19/02/2023 01:34:02 PM
 */
public interface ITransferenciasDAO {
    
    Transferencia consultar(Integer id_transferencia);
    
    Transferencia insertar(Transferencia transferencia) throws PersistenciaException;
    
    Integer realizarTransferencia(Transferencia transferencia) throws PersistenciaException;
}

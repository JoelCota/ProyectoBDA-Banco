/**
 * PersistenciaException.java
 */
package Excepciones;

/**
 * Esta clase permite crear excepciones de tipo Persistencia.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por omisión.
     */
    public PersistenciaException() {
        super();
    }

    /**
     * Constructor que establece un mensaje en la excepción.
     *
     * @param msj Mensaje para la excepción
     */
    public PersistenciaException(String msj) {
        super(msj);
    }

    /**
     * Constructor que establece un mensaje en la excepción y su causa.
     *
     * @param msj Mensaje para la excepción
     * @param causa Causa de la excepción
     */
    public PersistenciaException(String msj, Throwable causa) {
        super(msj, causa);
    }

    /**
     * Constructor que establece la causa de la excpeción.
     *
     * @param causa Causa de la excepción
     */
    public PersistenciaException(Throwable causa) {
        super(causa);
    }

    /**
     * Constructor que establece un mensaje en la excepción y su causa.
     *
     * @param msj Mensaje para la excepción
     * @param causa Causa de la excepción
     * @param enableSuppression Booleano supresión
     * @param writableStackTrace Booleando escritura
     */
    public PersistenciaException(String msj, Throwable causa, boolean enableSuppression, boolean writableStackTrace) {
        super(msj, causa, enableSuppression, writableStackTrace);
    }
}

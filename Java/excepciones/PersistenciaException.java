/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Clase que nos ayuda con las persistencias
 * @author Joel Lopez
 */
public class PersistenciaException extends Exception{
    
    public PersistenciaException() {
    }

    public PersistenciaException(String mensaje) {
        super(mensaje);
    }

    public PersistenciaException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    public PersistenciaException(String mensaje, Throwable cause, boolean bln, boolean bln1) {
        super(mensaje, cause, bln, bln1);
    }
    
}


/**
 * Operacion.java
 */
package Dominio;

// Importaciones
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Operacion.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 */
public class Operacion {

    // Atributos
    private Integer folio;
    private String fecha_hora;
    private Float monto_pesos;
    private Integer num_cuenta_origen;
    private String tipoTransaccion;

    /**
     * Constructor vacio
     */
    public Operacion() {
    }

    /**
     * Constructor que inicializa los atributos del parametro
     *
     * @param folio es el folio de la operacion
     * @param fecha_hora es la fecha de la operacion
     * @param monto_pesos es el monto en pesos de la operacion
     * @param num_cuenta_origen es el numero cuenta origen de la operacion
     * @param tipoTransaccion es el tipo de transaccion que realiza
     */
    public Operacion(Integer folio, String fecha_hora, Float monto_pesos, Integer num_cuenta_origen, String tipoTransaccion) {
        this.folio = folio;
        this.fecha_hora = fecha_hora;
        this.monto_pesos = monto_pesos;
        this.num_cuenta_origen = num_cuenta_origen;
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Constructor que inicializa los atributos del parametro
     *
     * @param fecha_hora es la fecha de la operacion
     * @param monto_pesos es el monto en pesos de la operacion
     * @param num_cuenta_origen es el numero cuenta origen de la operacion
     * @param tipoTransaccion es el tipo de transaccion que realiza
     */
    public Operacion(String fecha_hora, Float monto_pesos, Integer num_cuenta_origen, String tipoTransaccion) {
        this.fecha_hora = fecha_hora;
        this.monto_pesos = monto_pesos;
        this.num_cuenta_origen = num_cuenta_origen;
        this.tipoTransaccion = tipoTransaccion;

    }

    /**
     * Constructor que inicializa los atributos del parametro
     *
     * @param monto_pesos es el monto en pesos de la operacion
     * @param num_cuenta_origen es el numero cuenta origen de la operacion
     * @param tipoTransaccion es el tipo de transaccion que realiza
     */
    public Operacion(Float monto_pesos, Integer num_cuenta_origen, String tipoTransaccion) {
        this.monto_pesos = monto_pesos;
        this.num_cuenta_origen = num_cuenta_origen;
        this.tipoTransaccion = tipoTransaccion;

    }
    /**
     * Metodo que permite acceder al tipo de transaccion
     * @return el tipo de transaccion de la operacion
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }
    /**
     * Metodo que setea el tipo de transaccion
     * @param tipoTransaccion es el tipo de transaccicon de la operacion
     */
    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    /**
     * Metodo que permite acceder al folio
     * @return el folio de la operacion
     */
    public Integer getFolio() {
        return folio;
    }
    /**
     * Metodo que permite setear el folio de la operacion
     * @param folio es el folio a setear
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }
    /**
     * Metodo que te permite acceder a la fecha y hora de la operacion
     * @return la fecha y hora de la operacion
     */
    public String getFecha_hora() {
        return fecha_hora;
    }
    /**
     * Metodo que permite setear la fecha y hora de la opepracion
     * @param fecha_hora es la fecha hora a setear
     */
    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
    /**
     * Metodo que permite acceder al monto en pesos
     * @return el monto en pesos
     */
    public Float getMonto_pesos() {
        return monto_pesos;
    }
    /**
     * Metodo que permite setear el monto de pesos de la operacion
     * @param monto_pesos es el monto en pesos de la operacion
     */
    public void setMonto_pesos(Float monto_pesos) {
        this.monto_pesos = monto_pesos;
    }
    /**
     * Metodo que permite acceder al numero cuenta de origen
     * @return el numero cuenta origen
     */
    public Integer getNum_cuenta_origen() {
        return num_cuenta_origen;
    }

    public void setNum_cuenta_origen(Integer num_cuenta_origen) {
        this.num_cuenta_origen = num_cuenta_origen;
    }

    /**
     * Metodo hash code
     *
     * @return el hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.folio);
        return hash;
    }

    /**
     * Metodo equals
     *
     * @param obj es el objeto a comparar
     * @return true si es igual false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operacion other = (Operacion) obj;
        return true;
    }

    /**
     * Metodo to string
     *
     * @return regresa los atributos en una cadena de texto
     */
    @Override
    public String toString() {
        return "Operacion{" + "folio=" + folio + ", fecha_hora=" + fecha_hora + ", monto_pesos=" + monto_pesos + ", num_cuenta_origen=" + num_cuenta_origen + '}';
    }
}

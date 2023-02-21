/**
 * Cuenta.java
 */
package Dominio;

// Importaciones
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Cuenta.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 15/02/2023 11:53:23 PM
 */
public class Cuenta {

    // Atributos
    private Integer num_cuenta;
    private String fecha_hora_apertura;
    private Float saldo;
    private String estado;
    private Integer id_cliente;

    /**
     * Constructor Vacio
     */
    public Cuenta() {
    }

    /**
     * Constructor que inicia los datos del paramtro
     * @param num_cuenta es el numero de cuenta a setear
     * @param saldo es el saldo a setear
     */
    public Cuenta(Integer num_cuenta, Float saldo) {
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
    }

    /**
     * Constructor que inicia los datos del paramtro
     * @param num_cuenta es el numero de cuenta a setear
     * @param id_cliente es el id del cliente a setear
     */
    public Cuenta(Integer num_cuenta, Integer id_cliente) {
        this.num_cuenta = num_cuenta;
        this.id_cliente = id_cliente;
    }

    /**
     * Constructor que inicia los datos del paramtro
     * @param num_cuenta es el numero de cuenta a setear
     */
    public Cuenta(Integer num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    /**
      * Constructor que inicia los datos del paramtro
     * @param saldo es el saldo a setear
     * @param id_cliente es el id del cliente a setear
     */
    public Cuenta(Float saldo, Integer id_cliente) {
        this.saldo = saldo;
        this.id_cliente = id_cliente;
    }

    /**
      * Constructor que inicia los datos del paramtro
     * @param num_cuenta es el numero de cuenta a setear
     * @param saldo es el saldo a setear
     * @param estado es el estado a setear
     */
    public Cuenta(Integer num_cuenta, Float saldo, String estado) {
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    /**
     * Constructor que inicia los datos del paramtro
     * @param num_cuenta es el numero de cuenta a setear
     * @param fecha_hora_apertura es la fecha de apertura a setear
     * @param saldo es el saldo a setear
     * @param estado es el estado a setear
     * @param id_cliente es el id del cliente a setear
     */
    public Cuenta(Integer num_cuenta, String fecha_hora_apertura, Float saldo, String estado, Integer id_cliente) {
        this.num_cuenta = num_cuenta;
        this.fecha_hora_apertura = fecha_hora_apertura;
        this.saldo = saldo;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    /**
     * Constructor que inicia los datos del paramtro
     * @param fecha_hora_apertura es la fecha de apertura a setear
     * @param saldo es el saldo a setear
     * @param estado es el estado a setear
     * @param id_cliente es el id del cliente a setear
     */
    public Cuenta(String fecha_hora_apertura, Float saldo, String estado, Integer id_cliente) {
        this.fecha_hora_apertura = fecha_hora_apertura;
        this.saldo = saldo;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    /**
     * Metodo que permite acceder al numero de cuenta 
     * @return el numero de cuenta de la cuenta
     */
    public Integer getNum_cuenta() {
        return num_cuenta;
    }

    /**
     * Metodo que permite setear el numero de cuenta
     * @param num_cuenta es el numero de cuenta a setear
     */
    public void setNum_cuenta(Integer num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    /**
     * Metodo que permite acceder a la fecha de apertura de la cuenta
     * @return la fecha de apertura de la cuenta
     */
    public String getFecha_hora_apertura() {
        return fecha_hora_apertura;
    }

    /**
     * Metodo que permite acceder a la fecha de apertura
     * @param fecha_hora_apertura es la fecha que se desea setear
     */
    public void setFecha_hora_apertura(String fecha_hora_apertura) {
        this.fecha_hora_apertura = fecha_hora_apertura;
    }

    /**
     * Metodo que permite acceder al saldo de la cuenta
     * @return el saldo de la cuenta
     */
    public Float getSaldo() {
        return saldo;
    }

    /**
     * Metodo que permite setear el valor del saldo
     * @param saldo es el saldo a setear
     */
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    /**
     * Metodo que permite accceder al estado de la cuenta
     * @return el estado del cliente
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo uqe permite setear el estado de la cuenta
     * @param estado es el estado de la cuenta
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo que permite acceder al id cliente
     * @return el id  del cliente
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     * Metodo que setea el id del cliente
     * @param id_cliente es el id que se desea setear
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Metodo hash code
     * @return el hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.num_cuenta);
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
        final Cuenta other = (Cuenta) obj;
        return true;
    }

    /**
     * Metodo to string
     *
     * @return los atributos en string
     */
    @Override
    public String toString() {
        return "Cuentas{" + "num_cuenta=" + num_cuenta + ", fecha_hora_apertura=" + fecha_hora_apertura + ", saldo=" + saldo + ", estado=" + estado + ", id_cliente=" + id_cliente + '}';
    }
}

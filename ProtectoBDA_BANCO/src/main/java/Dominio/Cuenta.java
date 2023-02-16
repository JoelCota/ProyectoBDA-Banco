/**
 * Cuenta.java
 */

package Dominio;

// Importaciones
import java.sql.Date;
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Cuenta.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 * 15/02/2023 11:53:23 PM
 */
public class Cuenta {
    // Atributos
    private Integer num_cuenta;
    private Date fecha_hora_apertura;
    private Float saldo;
    private String estado; 
    private Integer id_cliente;

    public Cuenta() {
    }

    public Cuenta(Integer num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public Cuenta(Integer num_cuenta, Date fecha_hora_apertura, Float saldo, String estado, Integer id_cliente) {
        this.num_cuenta = num_cuenta;
        this.fecha_hora_apertura = fecha_hora_apertura;
        this.saldo = saldo;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    public Cuenta(Date fecha_hora_apertura, Float saldo, String estado, Integer id_cliente) {
        this.fecha_hora_apertura = fecha_hora_apertura;
        this.saldo = saldo;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    public Integer getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(Integer num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public Date getFecha_hora_apertura() {
        return fecha_hora_apertura;
    }

    public void setFecha_hora_apertura(Date fecha_hora_apertura) {
        this.fecha_hora_apertura = fecha_hora_apertura;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.num_cuenta);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Cuentas{" + "num_cuenta=" + num_cuenta + ", fecha_hora_apertura=" + fecha_hora_apertura + ", saldo=" + saldo + ", estado=" + estado + ", id_cliente=" + id_cliente + '}';
    }
}

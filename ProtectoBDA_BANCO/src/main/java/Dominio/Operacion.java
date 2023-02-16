/**
 * Operacion.java
 */

package Dominio;

// Importaciones
import java.sql.Date;
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Operacion.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 * 15/02/2023 11:56:45 PM
 */
public class Operacion {
    // Atributos
    private Integer folio;
    private Date fecha_hora;
    private Float monto_pesos;
    private Integer num_cuenta_origen;

    public Operacion() {
    }

    public Operacion(Integer folio, Date fecha_hora, Float monto_pesos, Integer num_cuenta_origen) {
        this.folio = folio;
        this.fecha_hora = fecha_hora;
        this.monto_pesos = monto_pesos;
        this.num_cuenta_origen = num_cuenta_origen;
    }

    public Operacion(Date fecha_hora, Float monto_pesos, Integer num_cuenta_origen) {
        this.fecha_hora = fecha_hora;
        this.monto_pesos = monto_pesos;
        this.num_cuenta_origen = num_cuenta_origen;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Float getMonto_pesos() {
        return monto_pesos;
    }

    public void setMonto_pesos(Float monto_pesos) {
        this.monto_pesos = monto_pesos;
    }

    public Integer getNum_cuenta_origen() {
        return num_cuenta_origen;
    }

    public void setNum_cuenta_origen(Integer num_cuenta_origen) {
        this.num_cuenta_origen = num_cuenta_origen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.folio);
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
        final Operacion other = (Operacion) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Operacion{" + "folio=" + folio + ", fecha_hora=" + fecha_hora + ", monto_pesos=" + monto_pesos + ", num_cuenta_origen=" + num_cuenta_origen + '}';
    }
}
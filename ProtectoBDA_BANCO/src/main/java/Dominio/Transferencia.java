/**
 * Transferencia.java
 */

package Dominio;

// Importaciones
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Transferencia.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * 16/02/2023 12:00:30 AM
 */
public class Transferencia {
    // Atributos
    private Integer id_transferencia;
    private Integer num_cuenta_destino;
    private Integer folio;

    public Transferencia() {
    }

    public Transferencia(Integer id_transferencia, Integer num_cuenta_destino, Integer folio) {
        this.id_transferencia = id_transferencia;
        this.num_cuenta_destino = num_cuenta_destino;
        this.folio = folio;
    }

    public Transferencia(Integer num_cuenta_destino, Integer folio) {
        this.num_cuenta_destino = num_cuenta_destino;
        this.folio = folio;
    }

    public Integer getId_transferencia() {
        return id_transferencia;
    }

    public void setId_transferencia(Integer id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public Integer getNum_cuenta_destino() {
        return num_cuenta_destino;
    }

    public void setNum_cuenta_destino(Integer num_cuenta_destino) {
        this.num_cuenta_destino = num_cuenta_destino;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_transferencia);
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
        final Transferencia other = (Transferencia) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "id_transferencia=" + id_transferencia + ", num_cuenta_destino=" + num_cuenta_destino + ", folio=" + folio + '}';
    }
}

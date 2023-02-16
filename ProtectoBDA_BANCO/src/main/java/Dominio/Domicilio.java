/**
 * Domicilio.java
 */

package Dominio;

// Importaciones
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Domicilio.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 * 15/02/2023 06:17:45 PM
 */
public class Domicilio {
    // Atributos
    private Integer id_domicilio;
    private String colonia;
    private String calle;
    private String numero;

    public Domicilio() {
    }

    public Domicilio(Integer id_domicilio, String colonia, String calle, String numero) {
        this.id_domicilio = id_domicilio;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    public Domicilio(String colonia, String calle, String numero) {
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    public Integer getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(Integer id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id_domicilio);
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
        final Domicilio other = (Domicilio) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "id_domicilio=" + id_domicilio + ", colonia=" + colonia + ", calle=" + calle + ", numero=" + numero + '}';
    }
}

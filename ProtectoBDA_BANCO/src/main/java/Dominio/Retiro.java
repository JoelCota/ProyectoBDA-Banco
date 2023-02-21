/**
 * Retiro.java
 */

package Dominio;

// Importaciones
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Retiro.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * 16/02/2023 12:03:24 AM
 */
public class Retiro {
    // Atributos
    private Integer id_retiro;
    private Integer contrasena;
    private String estado;
    private Integer folio;
    private Operacion operacion;
    
    public Retiro() {
    }

    public Retiro(Integer id_retiro, Integer contrasena, String estado, Integer folio, Operacion operacion) {
        this.id_retiro = id_retiro;
        this.contrasena = contrasena;
        this.estado = estado;
        this.folio = folio;
        this.operacion = operacion;
    }
    
    public Retiro(Integer id_retiro, Integer contrasena, String estado, Integer folio) {
        this.id_retiro = id_retiro;
        this.contrasena = contrasena;
        this.estado = estado;
        this.folio = folio;
    }

    public Retiro(Integer contrasena, String estado, Integer folio) {
        this.contrasena = contrasena;
        this.estado = estado;
        this.folio = folio;
    }

    public Retiro(Integer contrasena, Integer folio) {
        this.contrasena = contrasena;
        this.folio = folio;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public Integer getId_retiro() {
        return id_retiro;
    }

    public void setId_retiro(Integer id_retiro) {
        this.id_retiro = id_retiro;
    }

    public Integer getContrasena() {
        return contrasena;
    }

    public void setContrasena(Integer contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash = 97 * hash + Objects.hashCode(this.id_retiro);
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
        final Retiro other = (Retiro) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Retiro{" + "id_retiro=" + id_retiro + ", contrasena=" + contrasena + ", estado=" + estado + ", folio=" + folio + '}';
    }
}

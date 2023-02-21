/**
 * Retiro.java
 */
package Dominio;

// Importaciones
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Retiro.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295 16/02/2023 12:03:24 AM
 */
public class Retiro {

    // Atributos
    private Integer id_retiro;
    private Integer contrasena;
    private String estado;
    private Integer folio;
    private Operacion operacion;

    /**
     * Constructor vacio
     */
    public Retiro() {
    }

    /**
     * Constructor que inicializa los valores del paramentro
     *
     * @param id_retiro es el id del retiro
     * @param contrasena es la contraseña del retiro
     * @param estado es el estado del retiro
     * @param folio es el folio del retiro
     * @param operacion es la operacion a la que pertenece el retiro
     */
    public Retiro(Integer id_retiro, Integer contrasena, String estado, Integer folio, Operacion operacion) {
        this.id_retiro = id_retiro;
        this.contrasena = contrasena;
        this.estado = estado;
        this.folio = folio;
        this.operacion = operacion;
    }

    /**
     * Constructor que inicializa los valores del paramentro
     *
     * @param id_retiro es el id del retiro
     * @param contrasena es la contraseña del retiro
     * @param estado es el estado del retiro
     * @param folio es el folio del retiro
     */
    public Retiro(Integer id_retiro, Integer contrasena, String estado, Integer folio) {
        this.id_retiro = id_retiro;
        this.contrasena = contrasena;
        this.estado = estado;
        this.folio = folio;
    }

    /**
     * Constructor que inicializa los valores del paramentro
     *
     * @param contrasena es la contraseña del retiro
     * @param estado es el estado del retiro
     * @param folio es el folio del retiro
     */
    public Retiro(Integer contrasena, String estado, Integer folio) {
        this.contrasena = contrasena;
        this.estado = estado;
        this.folio = folio;
    }
  /**
     * Constructor que inicializa los valores del paramentro
     * @param contrasena es la contraseña del retiro
     * @param folio es el folio del retiro
     */
    public Retiro(Integer contrasena, Integer folio) {
        this.contrasena = contrasena;
        this.folio = folio;
    }
    /**
     * Metodo que permite accedeer a la operacion
     * @return la operacion a la que permite el retiro
     */
    public Operacion getOperacion() {
        return operacion;
    }
    /**
     * Metodo que permtie setear la operacion
     * @param operacion es la operacion que se desea setear
     */
    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }
    /**
     * Metodo que permite acceder al id del retirno
     * @return el id del retiro
     */
    public Integer getId_retiro() {
        return id_retiro;
    }
    /**
     * Metodo que permite setear el id del retirno
     * @param id_retiro es el id a setear
     */
    public void setId_retiro(Integer id_retiro) {
        this.id_retiro = id_retiro;
    }
    /**
     * Metodo que permite acceder a la contraseña del retiro
     * @return la contraseña del retiro
     */
    public Integer getContrasena() {
        return contrasena;
    }
    /**
     * Metodo que permite setear la contraseña
     * @param contrasena la contraseña a setear
     */
    public void setContrasena(Integer contrasena) {
        this.contrasena = contrasena;
    }
    /**
     * Metodo que permite acceder al estado del retiro
     * @return el estado del retiro
     */
    public String getEstado() {
        return estado;
    }
    /**
     * Metodo que permite setear el estado del retiro
     * @param estado es el estado a setear
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Metodo que permite accceder al folio del retiro
     * @return el folio del retiro
     */
    public Integer getFolio() {
        return folio;
    }
    /**
     * Metodo que permite setear el folio del retiro
     * @param folio es el folio del retiro
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    /**
     * Metodo hash code
     *
     * @return el hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_retiro);
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
        final Retiro other = (Retiro) obj;
        return true;
    }

    /**
     * Metodo to string
     *
     * @return regresa los atributos en una cadena de texto
     */
    @Override
    public String toString() {
        return "Retiro{" + "id_retiro=" + id_retiro + ", contrasena=" + contrasena + ", estado=" + estado + ", folio=" + folio + '}';
    }
}

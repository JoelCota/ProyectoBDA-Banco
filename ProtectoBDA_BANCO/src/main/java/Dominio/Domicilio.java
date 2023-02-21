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
 */
public class Domicilio {

    // Atributos
    private Integer id_domicilio;
    private String colonia;
    private String calle;
    private String numero;
    /**
     * Constructor vacio
     */
    public Domicilio() {
    }

    /**
     * Constructor que inicializa los atributos del parametro
     *
     * @param id_domicilio es el id del domicilio
     * @param calle es la calle del domicilio
     * @param numero es el numero del domicilio
     * @param colonia es la colonia del domicilio
     */
    public Domicilio(Integer id_domicilio, String calle, String numero, String colonia) {
        this.id_domicilio = id_domicilio;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    /**
     * Constructor que inicializa los atributos del parametro
     *
     * @param calle es la calle del domicilio
     * @param numero es el numero del domicilio
     * @param colonia es la colonia del domicilio
     */
    public Domicilio(String colonia, String calle, String numero) {
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }
    /**
     * Metodo que permite acceder al id del domicilio
     * @return el id del domicilio
     */
    public Integer getId_domicilio() {
        return id_domicilio;
    }
    /**
     * Metodo que permite setear el id del domicilio
     * @param id_domicilio es el id a setear
     */
    public void setId_domicilio(Integer id_domicilio) {
        this.id_domicilio = id_domicilio;
    }
    /**
     * Metodo que permite acceder a la colonia 
     * @return la colonia del domicilio
     */
    public String getColonia() {
        return colonia;
    }
    /**
     * Metodo que permite setear la colonia en el domicilio
     * @param colonia es la colonia que se desea setear
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    /**
     * Metodo que permite acceder a la calle del domicilio
     * @return la calle del domicilio
     */
    public String getCalle() {
        return calle;
    }
    /**
     * Metodo que permite setear la calle del domicilio
     * @param calle es la calle a setear
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    /**
     * Metodo que permite acceder al numero del domicilio
     * @return el numero del domicilio
     */
    public String getNumero() {
        return numero;
    }
    /**
     * Metodo que permite setear el numero del cliente
     * @param numero 
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Metodo hash code
     *
     * @return el hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id_domicilio);
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
        final Domicilio other = (Domicilio) obj;
        return true;
    }

    /**
     * Metodo to string
     *
     * @return regresa los atributos en una cadena de texto
     */
    @Override
    public String toString() {
        return "Domicilio{" + "id_domicilio=" + id_domicilio + ", colonia=" + colonia + ", calle=" + calle + ", numero=" + numero + '}';
    }
}

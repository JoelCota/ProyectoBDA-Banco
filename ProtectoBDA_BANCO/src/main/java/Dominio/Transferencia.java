/**
 * Transferencia.java
 */
package Dominio;

// Importaciones
import Dominio.*;
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Transferencia.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 */
public class Transferencia {

    // Atributos
    private Integer id_transferencia;
    private Integer num_cuenta_destino;
    private Integer folio;

    /**
     * Constructor vacio
     */
    public Transferencia() {
    }

    /**
     * Constructor que inicialiaza los atributos a los del parametro
     *
     * @param id_transferencia es la id de la transferencia
     * @param num_cuenta_destino es el numero de cuenta de destino
     * @param folio es el folio de transferencia
     */
    public Transferencia(Integer id_transferencia, Integer num_cuenta_destino, Integer folio) {
        this.id_transferencia = id_transferencia;
        this.num_cuenta_destino = num_cuenta_destino;
        this.folio = folio;
    }

    /**
     * Constructor que inicialiaza los atributos a los del parametro
     *
     * @param num_cuenta_destino es el numero de cuenta de destino
     * @param folio es el folio de transferencia
     */
    public Transferencia(Integer num_cuenta_destino, Integer folio) {
        this.num_cuenta_destino = num_cuenta_destino;
        this.folio = folio;
    }

    /**
     * Metodo que permite acceder al id de la transferencia
     *
     * @return el id de la transferencia
     */
    public Integer getId_transferencia() {
        return id_transferencia;
    }

    /**
     * Metodo que permite setear el id de la transferencia
     *
     * @param id_transferencia es el id a setear
     */
    public void setId_transferencia(Integer id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    /**
     * Metodo que permite acceder al numero de cuenta de destino
     *
     * @return el numero de cuenta de destino
     */
    public Integer getNum_cuenta_destino() {
        return num_cuenta_destino;
    }

    /**
     * Metodo que permite setear el numero de cuenta de destino
     *
     * @param num_cuenta_destino es el numero cuenta de destino
     */
    public void setNum_cuenta_destino(Integer num_cuenta_destino) {
        this.num_cuenta_destino = num_cuenta_destino;
    }

    /**
     * Metodo que permite acceder al folio de la transferencia
     *
     * @return el folio de la transferencia
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * Metodo que permite setear el folio de la transferencia
     *
     * @param folio es el folio a setear
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
        hash = 97 * hash + Objects.hashCode(this.id_transferencia);
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
        final Transferencia other = (Transferencia) obj;
        return true;
    }

    /**
     * Metodo to string
     *
     * @return regresa los atributos en una cadena de texto
     */
    @Override
    public String toString() {
        return "Transferencia{" + "id_transferencia=" + id_transferencia + ", num_cuenta_destino=" + num_cuenta_destino + ", folio=" + folio + '}';
    }
}

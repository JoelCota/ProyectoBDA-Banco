/**
 * Cliente.java
 */

package Dominio;

// Importaciones
import java.sql.Date;
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Cliente.
 *
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 * 15/02/2023 06:08:26 PM
 */
public class Cliente {
    // Atributos
    private Integer id_cliente;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private Date fecha_nacimiento;
    private Integer edad;
    private Integer id_domicilio;

    public Cliente() {
    }

    public Cliente(Integer id_cliente, String nombres, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, Integer edad, Integer id_domicilio) {
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.id_domicilio = id_domicilio;
    }

    public Cliente(String nombres, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, Integer edad, Integer id_domicilio) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.id_domicilio = id_domicilio;
    }

    public Cliente(Integer id_cliente, String nombres, String apellido_paterno, String apellido_materno, Integer id_domicilio) {
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.id_domicilio = id_domicilio;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(Integer id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id_cliente);
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
        final Cliente other = (Cliente) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", fecha_nacimiento=" + fecha_nacimiento + ", edad=" + edad + ", id_domicilio=" + id_domicilio + '}';
    }
}

/**
 * Cliente.java
 */
package Dominio;

// Importaciones
import java.util.Objects;

/**
 * Esta clase permite crear objetos de tipo Cliente.
 *
 * @author Brandon Figueroa Ugalde ID: 00000233295
 * @author Joel Antonio Lopez Cota ID: 00000228926 15/02/2023 06:08:26 PM
 */
public class Cliente {

    // Atributos
    private Integer id_cliente;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_nacimiento;
    private Integer edad;
    private String contrasena;
    private Integer id_domicilio;

    /**
     * Constructor Vacio
     */
    public Cliente() {
    }

    /**
     * Constructor que inicia los valores del parametro
     *
     * @param id_cliente el id del cliente en la base de datos
     * @param nombres el nombre del cliente
     * @param apellido_paterno el apellido paterno del cliente
     * @param apellido_materno el apellido materno del cliente
     * @param fecha_nacimiento la fecha de nacimiento del cliente
     * @param edad la edad del cliente
     * @param contrasena la contraseña del cliente
     * @param id_domicilio el id del dodmicilio que le pertenece
     */
    public Cliente(Integer id_cliente, String nombres, String apellido_paterno, String apellido_materno, String fecha_nacimiento, Integer edad, String contrasena, Integer id_domicilio) {
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.contrasena = contrasena;
        this.id_domicilio = id_domicilio;
    }

    /**
     * Constructor que incializa los valores del parametro
     *
     * @param nombres el nombre del cliente
     * @param apellido_paterno el apellido paterno del cliente
     * @param apellido_materno el apellido materno del cliente
     * @param fecha_nacimiento la fecha de nacimiento del cliente
     * @param contrasena la contraseña del cliente
     * @param id_domicilio el id del dodmicilio que le pertenece
     */
    public Cliente(String nombres, String apellido_paterno, String apellido_materno, String fecha_nacimiento, String contrasena, Integer id_domicilio) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.contrasena = contrasena;
        this.id_domicilio = id_domicilio;
    }

    /**
     * Constructor que inicializa valores
     *
     * @param id_cliente el id del cliente en la base de datos
     * @param nombres el nombre del cliente
     * @param apellido_paterno el apellido paterno del cliente
     * @param apellido_materno el apellido materno del cliente
     * @param fecha_nacimiento la fecha de nacimiento del cliente
     * @param edad la edad del cliente
     * @param id_domicilio el id del dodmicilio que le pertenece
     */
    public Cliente(Integer id_cliente, String nombres, String apellido_paterno, String apellido_materno, String fecha_nacimiento, Integer edad, Integer id_domicilio) {
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.id_domicilio = id_domicilio;
    }

    /**
     * Constructor que inicia los valores del parametro
     *
     * @param nombres el nombre del cliente
     * @param apellido_paterno el apellido paterno del cliente
     * @param apellido_materno el apellido materno del cliente
     * @param fecha_nacimiento la fecha de nacimiento del cliente
     * @param edad la edad del cliente
     * @param id_domicilio el id del dodmicilio que le pertenece
     */
    public Cliente(String nombres, String apellido_paterno, String apellido_materno, String fecha_nacimiento, Integer edad, Integer id_domicilio) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.id_domicilio = id_domicilio;
    }

    /**
     * Constructor que inicia los valores del parametro
     *
     * @param nombres el nombre del cliente
     * @param apellido_paterno el apellido paterno del cliente
     * @param apellido_materno el apellido materno del cliente
     * @param fecha_nacimiento la fecha de nacimiento del cliente
     * @param edad la edad del cliente
     * @param contrasena la contraseña del cliente
     * @param id_domicilio el id del dodmicilio que le pertenece
     */
    public Cliente(String nombres, String apellido_paterno, String apellido_materno, String fecha_nacimiento, Integer edad, String contrasena, Integer id_domicilio) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.contrasena = contrasena;
        this.id_domicilio = id_domicilio;
    }

    /**
     * Constructor que inicia los valores del parametro
     *
     * @param nombres el nombre del cliente
     * @param apellido_paterno el apellido paterno del cliente
     * @param apellido_materno el apellido materno del cliente
     * @param contrasena la contraseña del cliente
     */
    public Cliente(String nombres, String apellido_paterno, String apellido_materno, String fecha, String contrasena) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha;
        this.contrasena = contrasena;
    }

    /**
     * Constructor que inicia los valores del parametro
     *
     * @param id_cliente el id del cliente en la base de datos
     * @param nombres el nombre del cliente
     * @param apellido_paterno el apellido paterno del cliente
     * @param apellido_materno el apellido materno del cliente
     * @param contrasena la contraseña del cliente
     */
    public Cliente(int id_cliente, String nombres, String apellido_paterno, String apellido_materno, String fecha, String contrasena) {
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha;
        this.contrasena = contrasena;
    }

    /**
     * Metodo que permite acceder al id_cliente
     *
     * @return el id del cliente
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     * Meto que setea el id del cliente
     *
     * @param id_cliente es el id del cliente
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Metodo que permite acceder al nombre del cliente
     *
     * @return el nombre del cliente
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Metodo que setea el nombre del cliente
     *
     * @param nombres es el nombre del cliente que se desea agregar
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Metodo que permite acceder al apellido paterno
     *
     * @return el apellido paternoiente
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Metodo que setea el apellido paterno
     *
     * @param apellido_paterno es el apellido paterno del cliente
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Metodo que permite acceder al apellido materno
     *
     * @return el apellido materno del cliente
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Metodo que setea el apellido materno
     *
     * @param apellido_materno es el apellido materno del cliente
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Metodo que permite acceder a la fecha de nacimiento del cliente
     *
     * @return la fecha de nacimiento del cliente
     */
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Metodo que setea la fecha de nacimiento en el cliente
     *
     * @param fecha_nacimiento es la fecha que se va a setear al cliente
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Metodo que permite acceder a la edad del cliente
     *
     * @return la edad del cliente
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Metodo que permite setear la edad
     *
     * @param edad es la edad del cliente
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Metodo que permite acceder a la contraseña del cliente
     *
     * @return la contraseña del cliente
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo que permite setear la contraseña al cliente
     *
     * @param contrasena la contraseña que se va a setear
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Metodo que permite acceder al id del domicilio
     *
     * @return el id del domicilio del cliente
     */
    public Integer getId_domicilio() {
        return id_domicilio;
    }

    /**
     * Metodo que permite setear el id del domiiclio del cliente
     * @param id_domicilio es el id del domicilio a setear
     */
    public void setId_domicilio(Integer id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    /**
     * Metodo hash code
     * @return el hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id_cliente);
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
        final Cliente other = (Cliente) obj;
        return true;
    }

    /**
     * Metodo to string
     * @return los datos en string
     */
    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", fecha_nacimiento=" + fecha_nacimiento + ", edad=" + edad + ", contrasena=" + contrasena + ", id_domicilio=" + id_domicilio + '}';
    }
}

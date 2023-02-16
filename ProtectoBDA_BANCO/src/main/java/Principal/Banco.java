/**
 * Banco.java
 */

package Principal;

// Importaciones
import Dominio.Cliente;
import Implementaciones.ClientesDAO;
import Implementaciones.ConexionBD;
import Interfaces.IClientesDAO;
import Interfaces.IConexionBD;
import Presentacion.frmBanco;
import Presentacion.frmRegistrarCliente;

/**
 * Esta clase se utiliza para realizar consultas creando la conexión a la base
 * de datos.
 *
 * Materia: Base de Datos Avanzadas
 * Titular: Christian Gibrán Durán
 * @author Brandon Figueroa Ugalde
 * ID: 00000233295
 * @author Joel Antonio Lopez Cota 
 * ID: 00000228926
 * 15/02/2023 06:08:02 PM
 */
public class Banco {

    /**
     * Método main() en el que se invocan a los métodos de las clase #######.
     * @param args Los argumentos en la línea de comando
     */
    public static void main(String[] args) {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "233295"
        );
        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
        new frmBanco(clientesDAO).setVisible(true);
        
    }
}

 // @author Administrador
package bd;

import com.mysql.jdbc.Connection;
import static java.lang.Class.forName;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion implements IConexion {

    private Connection conn;

    @Override
    public Connection conectar() {
        try {
            //Uso del clase drive en mysql
            forName(DRIVER); //versión 5
            //forName(DRIVER8); //versión 8
            //realizar conexión
            this.conn=(Connection) DriverManager.getConnection("jdbc:mysql://"+SERVIDOR+"/"+BD+PARAMETROS, USUARIO,CONTRASEÑA);
            return this.conn;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Class: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error SQL: "+ex.getMessage());
        }
        return null;
    }

    @Override
    public void desconectar() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

} // Fin Clase Conexion 

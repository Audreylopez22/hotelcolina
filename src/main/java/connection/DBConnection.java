
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * se crean las variable conexion de tipo conexion y para ello se exporta la libreria para poder procesar la
 * información y extraerla de la BD
 */
public class DBConnection {
    Connection connection; 
    static String bd= "railway";
    static String port = "5978";
    static String login= "root";
    static String password = "K32bgOUIf3vJBcNNpsCj";
    static String ip="containers-us-west-87.railway.app";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://"+DBConnection.ip+":" + DBConnection.port + "/"+ DBConnection.bd;
            connection= DriverManager.getConnection(url,DBConnection.login,DBConnection.password);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion");
        }
        
    }
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar (){
        connection= null;
    }
    
}

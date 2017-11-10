/**
 *
 * imYoda &copy; MIT License
 *
**/
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_ops {

        public static Connection connect(){
            String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204116";
            String user = "sql3204116";
            String pass = "zvqRISreMC";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("yep2");
            } catch (ClassNotFoundException | SQLException e){
                System.out.println(e.getMessage());
            }
            return conn;
        }
        
        public static void main(String[] args) {
        connect();
    }
}

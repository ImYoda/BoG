/**
 *
 * imYoda &copy; MIT License
 *
**/
package accounts;
import static config.DB_ops.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class a_login {
    
    
    
    
    // second try, let's do it :p
    public static  boolean getLogged(int a_number, int a_pin){
        String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204116";
            String user = "sql3204116";
            String pass = "zvqRISreMC";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException e){
                System.out.println(e.getMessage());
            }
            String sql ="SELECT * FROM accounts WHERE a_number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,a_number);
            ResultSet rs = pstmt.executeQuery();
            // loop here
            rs.next();
            int db_a_number = rs.getInt("a_number");
            int db_a_pin = rs.getInt("a_pin");
            if(a_number == db_a_number && a_pin == db_a_pin){
            return true;
            } else {
                return false;
            }
            
            
            
        } catch(SQLException e){
            return false;
        }
    }
    
    
    
}

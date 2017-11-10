package accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loki
 */
public class Account {
    
    public int id;
    public static  int a_number;
    public int a_pin;
    public double a_balance;
    public String a_holder;
    public String a_exp_date;
    public int a_type;
    
    public Account(int id, int a_number, int a_pin, double a_balance, String a_holder, String a_exp_date, int a_type){
        this.id = id;
        this.a_number = a_number;
        this.a_pin = a_pin;
        this.a_balance = a_balance;
        this.a_holder = a_holder;
        this.a_exp_date = a_exp_date;
        this.a_type = a_type;
    }
    
    public static String getHolder(int a_number){
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
            String sql ="SELECT a_holder FROM accounts WHERE a_number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,a_number);
            ResultSet rs = pstmt.executeQuery();
            // loop here
            rs.next();
            
            String db_a_holder = rs.getString("a_holder");
            
            return db_a_holder;
            
        } catch(SQLException e){
            return null;
        }
    }
    
    public static String getBalance(int a_number){
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
            String sql ="SELECT a_balance FROM accounts WHERE a_number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,a_number);
            ResultSet rs = pstmt.executeQuery();
            // loop here
            rs.next();
            
            String balance = rs.getString("a_balance");
            
            return balance;
            
        } catch(SQLException e){
            return null;
        }
    }
    
    public int ret(int withdraw){
        this.a_balance = this.a_balance - withdraw;
        int saldocon = (int) Math.round(this.a_balance);
        return saldocon;
    }
    public static void main(String[] args) {
        System.out.println(getHolder(41523132));

    }
    
}

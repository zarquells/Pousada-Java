package mySQL;
import java.sql.*;
import javax.swing.JOptionPane;

public class Connection {
    public static Connection conexao(){
        java.sql.Connection conexao = null;

        String driver = "com.mysql.cj.jdbc.Driver";
        
        String url = "jdbc:mysql://localhost:3306/pousada";

        String user ="root";

        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            
        }catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        
        try{
            conexao = DriverManager.getConnection(url,user,password);
            return (Connection) conexao;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}
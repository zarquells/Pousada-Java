package Connection_SQL;
import java.sql.*;
import javax.swing.JOptionPane;

public class Connection_SQL {
    public static Connection conexao(){

        java.sql.Connection conexao = null;
        
        String driver = "com.mysql.cj.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/pousada";
        
        String user ="root";
        
        String password = "";   
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Carregado! Iniciando Aplicação...");
            
        }catch (ClassNotFoundException e) {
            throw new IllegalStateException("Não foi possível achar o driver referente na pasta: ", e);
            
        }

        try{
            conexao = DriverManager.getConnection(url,user,password);

            return conexao;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao bando de dados SQL: " + e, "Tentativa de conexão falhou!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            
            return null;
        }

    }
}

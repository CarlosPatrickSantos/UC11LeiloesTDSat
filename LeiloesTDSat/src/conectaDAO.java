
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
     private static Connection conn;
       private static final String url = "jdbc:mysql://localhost:3306/uc11?useSSL=false";
       private static final String user = "root";
       private static final String password = "katarina7";
    
       public static boolean conectarDB(){
      
        
        try {
        //Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Falha na conexão com o banco: " + ex.getMessage());
            return false;
        }
       }
        public static Connection getConnection() {
        if (conn == null) {
            conectarDB(); // Tenta conectar se a conexão estiver nula
        }
        return conn;
    }

    public static void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada com sucesso");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            // Podemos deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
}  
        
    
    



import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ticks
 */
public class ConexaoTeste {
    public static void main(String[] args) throws SQLException {
        conectaDAO dao = new conectaDAO();
        boolean conn = dao.conectarDB();
        
        if (conn) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } else {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    
    }
    
}

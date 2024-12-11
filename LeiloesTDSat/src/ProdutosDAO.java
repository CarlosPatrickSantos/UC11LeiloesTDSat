/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
   private Connection conn;
   private PreparedStatement prep;
   private ResultSet resultset;
   private ArrayList<ProdutosDTO> listagem = new ArrayList<>();
   
   public ProdutosDAO() {
       
       conectaDAO dao = new conectaDAO(); 
        this.conn = dao.getConnection(); 
        listagem = new ArrayList<>();
   }
           
    
    public void cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql); 
            stmt.setString(1, produto.getNome()); 
            stmt.setInt(2, produto.getValor()); 
            stmt.setString(3, produto.getStatus()); 
            stmt.executeUpdate(); stmt.close(); 
        } catch (SQLException e) { 
            e.printStackTrace(); }
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public void venderProduto(int id) {
        String sql = "UPDATE produtos Set status = 'Vendido' WHERE id = ?";
        
        try {
           
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeUpdate();
            stmt.close();
          }catch (SQLException e) {
              e.printStackTrace();
          }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
       String sql = "SELECT * FROM produtos";
     
     try {
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
     while (rs.next()) { 
         ProdutosDTO produto = new ProdutosDTO();
         produto.setId(rs.getInt("id")); 
         produto.setNome(rs.getString("nome")); 
         produto.setValor(rs.getInt("valor")); 
         produto.setStatus(rs.getString("status")); 
         listagem.add(produto);
      }
      
          rs.close(); 
          stmt.close(); 
      } catch (SQLException e) { 
          e.printStackTrace(); 
      } return listagem;
    } 
    
    
    
        
}


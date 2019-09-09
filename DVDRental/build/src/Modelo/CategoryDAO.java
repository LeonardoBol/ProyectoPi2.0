/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Modelo.Category;
import java.sql.*;
import java.util.ArrayList;
import Servicios.Fachada;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

/**
 *
 * @author crist
 */
public class CategoryDAO {
    public int grabarCategory(Category c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO category values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getCategoryid());
            pstm.setString(2, c.getName());
            pstm.setTimestamp(3, c.getLasUpdate());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    } 
     public int modificarCategory(Category c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE category " +
                         "SET name = ?, last_update = ? "
                    +    "WHERE category_id=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, c.getName());
            pstm.setTimestamp(2, c.getLasUpdate());
            pstm.setInt(3,c.getCategoryid());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
     
     public int borrarCategory(int category_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM category WHERE category_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, category_id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
      public ArrayList<Category> listadocategorias(int category_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Category> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(category_id==0){
                sql = "SELECT * FROM category ORDER BY category_id";            
            }else{
                sql = "SELECT * FROM category where category_id = ? "
                    + "ORDER BY category_id";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(category_id != 0){
                pstm.setInt(1, category_id);
            }
            
            rs = pstm.executeQuery();
                        
            Category category = null;
            while(rs.next()){
                category = new Category();
                category.setCategoryid(rs.getInt("category_id"));
               category.setName(rs.getString("name"));
                category.setLasUpdate(rs.getTimestamp("last_update"));
                listado.add(category);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
}

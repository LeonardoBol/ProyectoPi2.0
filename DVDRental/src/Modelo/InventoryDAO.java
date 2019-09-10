/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class InventoryDAO {
     public int grabarInventory(Inventory c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO inventory values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getinventory_ID());
            pstm.setInt(2, c.getfilm_ID());
            pstm.setInt(3, c.getstore_ID());
            pstm.setTimestamp(4, c.getLasUpdate());
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
     public int modificarInventory(Inventory c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE inventory " +
                         "SET film_id = ?,store_id = ?, last_update = ? "
                    +    "WHERE inventory_id=?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, c.getfilm_ID());
            pstm.setInt(2, c.getstore_ID());
            pstm.setTimestamp(3, c.getLasUpdate());
            pstm.setInt(4, c.getinventory_ID());
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
     
     public int borrarInventory(int inventory_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM inventory WHERE inventory_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, inventory_id);
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
      public ArrayList<Inventory> listadoInventory(int Inventory_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Inventory> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(Inventory_id==0){
                sql = "SELECT * FROM inventory ORDER BY inventory_id";            
            }else{
                sql = "SELECT * FROM inventory where store_id = ? "
                    + "ORDER BY inventory_id ";      
            }                     
            pstm = con.prepareStatement(sql);
            
            if(Inventory_id != 0){
                pstm.setInt(1, Inventory_id);
            }
            
            rs = pstm.executeQuery();
                        
           Inventory inventory = null;
            while(rs.next()){
                inventory = new Inventory();
                inventory.setinventory_ID(rs.getInt("inventory_id"));
               inventory.setfilm_ID(rs.getInt("film_id"));
               inventory.setstore_ID(rs.getInt("store_id"));
                inventory.setLasUpdate(rs.getTimestamp("last_update"));
                listado.add(inventory);
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

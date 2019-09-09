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
public class StoreDAO {
     public int grabarStore(Store c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO store values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getStore_id());
            pstm.setInt(2, c.getManager_id());
            pstm.setInt(3, c.getAddres_id());
            pstm.setTimestamp(4, c.getLast_update());
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
     public int modificarStore(Store c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE store " +
                         "SET addres_id = ?,manager_staff_id = ?, last_update = ? "
                    +    "WHERE store_id=?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, c.getAddres_id());
            pstm.setInt(2, c.getManager_id());
            pstm.setTimestamp(3, c.getLast_update());
            pstm.setInt(4,c.getStore_id());
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
     
     public int borrarStore(int store_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM store WHERE store_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, store_id);
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
      public ArrayList<Store> listadoStores(int address_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Store> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            String sql="";
            if(address_id==0){
                sql = "SELECT * FROM store ORDER BY store_id"; 
                
            }else{
                 
                sql = "SELECT * FROM store where address_id = ? "
                    + "ORDER BY store_id";      
            }                     
            pstm = con.prepareStatement(sql);
            
            if(address_id != 0){
                
                pstm.setInt(1, address_id);
                
            }
            
            rs = pstm.executeQuery();
                       
           Store a = null;
     
            while(rs.next()){
                
                a = new Store();
                a.setStore_id(rs.getInt("store_id"));
               a.setManager_id(rs.getInt("manager_staff_id"));
               a.setAddres_id(rs.getInt("address_id"));
               a.setLast_update(rs.getTimestamp("last_update"));
               listado.add(a);
                
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


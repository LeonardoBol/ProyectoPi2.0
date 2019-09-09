/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class StaffDAO {
    
     public int grabarStaff1(Staff c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
           con = Fachada.getConnection();
            String sql = "INSERT INTO staff values (?,?,?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getStaff_id());
            pstm.setString(2, c.getName());
            pstm.setString(3, c.getLastName());
            pstm.setInt(4, c.getAdressID());
            pstm.setString(5, c.getEmail());
            pstm.setInt(6, c.getStoreID());
            pstm.setBoolean(7, c.getActive());
            pstm.setString(8, c.getUsername());
            pstm.setString(9, c.getPassword());
            pstm.setTimestamp(10, c.getLasUpdate());
            pstm.setBytes(11, c.getPicture());
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
     
     public int grabarStaff(Staff c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
           con = Fachada.getConnection();
            String sql = "INSERT INTO staff values (?,?,?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getStaff_id());
            pstm.setString(2, c.getName());
            pstm.setString(3, c.getLastName());
            pstm.setInt(4, c.getAdressID());
            pstm.setString(5, c.getEmail());
            pstm.setInt(6, c.getStoreID());
            pstm.setBoolean(7, c.getActive());
            pstm.setString(8, c.getUsername());
            pstm.setString(9, c.getPassword());
            pstm.setTimestamp(10, c.getLasUpdate());
            pstm.setBytes(11, c.getPicture());
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
}

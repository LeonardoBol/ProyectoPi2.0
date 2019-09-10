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
 * @author Leonardo
 */
public class StaffDAO {
    
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
     
     
     
     public ArrayList<Staff> listarStaff(int staff_id){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Staff> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql = "";
            if(staff_id == 0){
                sql = "SELECT * FROM staff ORDER BY staff_id";
            }else {
                sql = "SELECT * FROM staff where staff_id = ? "
                        + "ORDER BY staff_id";
            }
            pstm = con.prepareStatement(sql);
            
            if (staff_id !=0){
                pstm.setInt(1, staff_id);
            }
            
            rs = pstm.executeQuery();
            
            Staff staff = null;
            while(rs.next()){
                staff = new Staff();
                staff.setStaff_id(rs.getInt("staff_id"));
                staff.setName(rs.getString("first_name"));
                staff.setLastname(rs.getString("last_name"));
                staff.setAdressID(rs.getInt("address_id"));
                staff.setEmail(rs.getString("email"));
                staff.setStoreID(rs.getInt("store_id"));
                staff.setActive(rs.getBoolean("active"));
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
                staff.setLasUpdate(rs.getTimestamp("last_update"));
                listado.add(staff);
            }
        }
        catch (SQLException ex){
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
     
     
     
     public int modificarStaff(Staff c){
         Connection con = null;
         PreparedStatement pstm;
         pstm = null;
         int rtdo = 0;
         try{
             con = Fachada.getConnection();
             String sql = "UPDATE staff " + 
                     "SET first_name = ?, last_name = ?, address_id = ?, email = ?, store_id = ?,"
                     + "active = ?, username = ?, password= ?, last_update = ?, picture = ?\n"
                     + "WHERE staff_id=?";
             pstm = con.prepareStatement(sql);
             pstm.setString(1, c.getName());
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
     
     
     
     
     public int borrarStaff(int staff_id){
         Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM staff WHERE staff_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, staff_id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }catch(SQLException ex){
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


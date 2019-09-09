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
public class AddresDAO {
    public int grabarAddres(Addres c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO address values (?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getAddresid());
            pstm.setString(2, c.getAddres());
            pstm.setString(3, c.getAddres2());
            pstm.setString(4, c.getDistrict());
            pstm.setInt(5, c.getCityid());
            pstm.setString(6, c.getPostalcode());
            pstm.setString(7, c.getPhone());
            pstm.setTimestamp(8, c.getLasUpdate());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código: " + 
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
     public int modificarAddres(Addres c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE addres " +
                         "SET address = ?,address2 = ?,district = ?,city_id = ?,postal_code = ?,phone = ?, last_update = ? "
                    +    "WHERE address_id=?";
            pstm.setString(1, c.getAddres());
            pstm.setString(2, c.getAddres2());
            pstm.setString(3, c.getDistrict());
            pstm.setInt(4, c.getCityid());
            pstm.setString(5, c.getPostalcode());
            pstm.setString(6, c.getPhone());
            pstm.setTimestamp(7, c.getLasUpdate());
            pstm.setInt(8, c.getAddresid());
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
     
     public int borrarAddres(int addres_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM address WHERE address_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, addres_id);
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
      public ArrayList<Addres> listadoAddres(int id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Addres> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id==0){
                sql = "SELECT * FROM address ORDER BY address_id";            
            }else{
                sql = "SELECT * FROM address where city_id = ? "
                    + "ORDER BY address_id";      
            }                     
            pstm = con.prepareStatement(sql);
            
            if(id != 0){
                pstm.setInt(1, id);
            }
            
            rs = pstm.executeQuery();
                        
           Addres a = null;
            while(rs.next()){
                a = new Addres();
                a.setAddresid(rs.getInt("address_id"));
               a.setAddres(rs.getString("address"));
               a.setAddres2(rs.getString("address2"));
               a.setDistrict(rs.getString("district"));
               a.setCityid(rs.getInt("city_id"));
               a.setPostalcode(rs.getString("postal_code"));
               a.setPhone(rs.getString("phone"));
               
               a.setLasUpdate(rs.getTimestamp("last_update"));
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

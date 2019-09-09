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
public class LenguajeDAO {
        public int grabarLenguaje(Lenguaje c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO language values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getLenguajeid());
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
     public int modificarLenguaje(Lenguaje c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE language " +
                         "SET name = ?, last_update = ? "
                    +    "WHERE language_id=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, c.getName());
            pstm.setTimestamp(2, c.getLasUpdate());
            pstm.setInt(3,c.getLenguajeid());
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
     
     public int borrarLenguaje(int lenguaje_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM language WHERE language_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, lenguaje_id);
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
      public ArrayList<Lenguaje> listadolenguajes(int lenguaje_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Lenguaje> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(lenguaje_id==0){
                sql = "SELECT * FROM language ORDER BY language_id";            
            }else{
                sql = "SELECT * FROM language where language_id = ? "
                    + "ORDER BY language_id";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(lenguaje_id != 0){
                pstm.setInt(1, lenguaje_id);
            }
            
            rs = pstm.executeQuery();
                        
           Lenguaje lenguaje = null;
            while(rs.next()){
                lenguaje = new Lenguaje();
                lenguaje.setLenguajeid(rs.getInt("language_id"));
               lenguaje.setName(rs.getString("name"));
                lenguaje.setLasUpdate(rs.getTimestamp("last_update"));
                listado.add(lenguaje);
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

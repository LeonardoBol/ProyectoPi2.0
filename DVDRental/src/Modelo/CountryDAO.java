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
public class CountryDAO {
        public int grabarPais(Country c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO country values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getCountryid());
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
     public int modificarCountry(Country c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE country " +
                         "SET country = ?, last_update = ? "
                    +    "WHERE country_id=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, c.getName());
            pstm.setTimestamp(2, c.getLasUpdate());
            pstm.setInt(3,c.getCountryid());
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
     
     public int borrarCountry(int country_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM country WHERE country_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, country_id);
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
      public ArrayList<Country> listadoCountry(int country_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Country> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(country_id==0){
                sql = "SELECT * FROM country ORDER BY country_id";            
            }else{
                sql = "SELECT * FROM country where country_id = ? "
                    + "ORDER BY country_id";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(country_id != 0){
                pstm.setInt(1, country_id);
            }
            
            rs = pstm.executeQuery();
                        
           Country country = null;
            while(rs.next()){
                country = new Country();
                country.setCountryid(rs.getInt("country_id"));
               country.setName(rs.getString("country"));
                country.setLasUpdate(rs.getTimestamp("last_update"));
                listado.add(country);
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

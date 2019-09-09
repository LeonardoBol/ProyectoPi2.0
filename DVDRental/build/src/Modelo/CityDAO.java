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
public class CityDAO {
     public int grabarCity(City c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO city values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getCity_id());
            pstm.setString(2, c.getCity());
            pstm.setInt(3, c.getCountry_id());
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
     public int modificarCity(City c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE city " +
                         "SET city = ?,country_id = ?, last_update = ? "
                    +    "WHERE city_id=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, c.getCity());
            pstm.setInt(2, c.getCountry_id());
            pstm.setTimestamp(3, c.getLast_update());
            pstm.setInt(4,c.getCity_id());
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
     
     public int borrarCity(int city_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM city WHERE city_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, city_id);
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
      public ArrayList<City> listadoCities(int country_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<City> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(country_id==0){
                sql = "SELECT * FROM city ORDER BY city_id";            
            }else{
                sql = "SELECT * FROM city where country_id = ? "
                    + "ORDER BY city_id";      
            }                     
            pstm = con.prepareStatement(sql);
            
            if(country_id != 0){
                pstm.setInt(1, country_id);
            }
            
            rs = pstm.executeQuery();
                        
           City city = null;
            while(rs.next()){
                city = new City();
                city.setCity_id(rs.getInt("city_id"));
               city.setCity(rs.getString("city"));
               city.setCountry_id(rs.getInt("country_id"));
                city.setLast_update(rs.getTimestamp("last_update"));
                listado.add(city);
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

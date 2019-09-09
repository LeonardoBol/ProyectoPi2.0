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
public class ActorDAO {
     public int grabarActor(Actor c){
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
       try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO actor values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getActorid());
            pstm.setString(2, c.getName());
            pstm.setString(3, c.getLastName());
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
     public int modificarActor(Actor c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE actor " +
                         "SET first_name = ?,last_name = ?, last_update = ? "
                    +    "WHERE actor_id=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, c.getName());
            pstm.setString(2, c.getLastName());
            pstm.setTimestamp(3, c.getLasUpdate());
            pstm.setInt(4,c.getActorid());
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
     
     public int borrarActor(int actor_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM actor WHERE actor_id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, actor_id);
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
      public ArrayList<Actor> listadoActores(int actor_id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Actor> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(actor_id==0){
                sql = "SELECT * FROM actor ORDER BY actor_id";            
            }else{
                sql = "SELECT * FROM actor where actor_id = ? "
                    + "ORDER BY actor_id";      
            }                     
            pstm = con.prepareStatement(sql);
            
            if(actor_id != 0){
                pstm.setInt(1, actor_id);
            }
            
            rs = pstm.executeQuery();
                        
           Actor actor = null;
            while(rs.next()){
                actor = new Actor();
                actor.setActorid(rs.getInt("actor_id"));
               actor.setName(rs.getString("first_name"));
               actor.setLastName(rs.getString("last_name"));
                actor.setLasUpdate(rs.getTimestamp("last_update"));
                listado.add(actor);
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

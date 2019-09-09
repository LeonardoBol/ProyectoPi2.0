/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Staff {
   
    private int staff_id;
    private String staff_name;
    private String staff_lastname;
    private int address_id;
    private String email;
    private int store_id;
    private boolean active;
    private String username;
    private String password;
    private Timestamp last_update;
    private byte[] picture;
    
    public Staff()
    {
        this.staff_id = 0;
        this.staff_name = "";
        this.staff_lastname = "";
        this.address_id = 0;
        this.email = "";
        this.store_id = 0;
        this.active = true;
        this.username = "username";
        this.password = "password";
        Date date = new Date();
        last_update=new Timestamp(date.getTime());
    }
    
    public void setStaff_id(int staff_id){
        this.staff_id= staff_id;
    }
    
    public int getStaff_id(){
        return staff_id;
    }
    
    public String getName(){
        return staff_name;
    }
    
     public String getLastName(){
        return staff_lastname;
    }
     
    public int getAdressID(){
        return address_id;
    }
     
    public String getEmail(){
        return email;
    } 
    public int getStoreID(){
        return store_id;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setLasUpdate(Timestamp last_Update){
        this.last_update=last_Update;
    }
    public Timestamp getLasUpdate(){
        return last_update;
    }
    
    public void setName(String name){
        this.staff_name = name;
    }
    
     public void setLastname(String lastname){
        this.staff_lastname = lastname;
    }
     
    public void setAdressID(int a){
        this.address_id = a;
    }
     
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setStoreID(int id){
        this.store_id = id;
    }
    
    public void setActive(boolean a){
        this.active = a;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setPicture(byte[] imagen){
        this.picture = imagen;
    }    
    
    public byte[] getPicture(){
        return picture;
    }
}

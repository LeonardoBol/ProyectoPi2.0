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
 * @author crist
 */
public class Actor {
      private int actor_id;
    private String actor_name;
     private String actor_Last_Name;
    private Timestamp last_update;
    //____Constructor__
    public Actor(int actor_id,String actor_name, String actor_Last_Name){
    this.actor_id=actor_id;
    this.actor_name=actor_name;
    this.actor_Last_Name= actor_Last_Name;
     Date date = new Date();
    last_update=new Timestamp(date.getTime());
}
       public Actor(){
    this.actor_id=0;
    this.actor_name="";
    this.actor_Last_Name="";
       Date date = new Date();
    last_update=new Timestamp(date.getTime());
} 
    
     //________Get&Set_____________
    public void setActorid(int actor_id){
        this.actor_id=actor_id;
    }
    public int getActorid(){
        return actor_id;
    }
    public void setName(String actor_name){
        this.actor_name=actor_name;
    }
    public String getName(){
        return actor_name;
    }
       public void setLastName(String actor_Last_Name){
        this.actor_Last_Name=actor_Last_Name;
    }
    public String getLastName(){
        return actor_Last_Name;
    }
    public void setLasUpdate(Timestamp last_Update){
        this.last_update=last_Update;
    }
    public Timestamp getLasUpdate(){
        return last_update;
    }
     //________________________  
}

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
public class Lenguaje {
  private int lenguaje_id;
    private String lenguaje_name;
    private Timestamp last_update;
    //____Constructor__
    public Lenguaje(int lenguaje_id,String lenguaje_name){
    this.lenguaje_id=lenguaje_id;
    this.lenguaje_name=lenguaje_name;
     Date date = new Date();
    last_update=new Timestamp(date.getTime());
}
       public Lenguaje(){
    this.lenguaje_id=0;
    this.lenguaje_name="";
       Date date = new Date();
    last_update=new Timestamp(date.getTime());
} 
    
     //________Get&Set_____________
    public void setLenguajeid(int lenguaje_id){
        this.lenguaje_id=lenguaje_id;
    }
    public int getLenguajeid(){
        return lenguaje_id;
    }
    public void setName(String lenguaje_name){
        this.lenguaje_name=lenguaje_name;
    }
    public String getName(){
        return lenguaje_name;
    }
   
    public void setLasUpdate(Timestamp last_Update){
        this.last_update=last_Update;
    }
    public Timestamp getLasUpdate(){
        return last_update;
    }
     //________________________  
}

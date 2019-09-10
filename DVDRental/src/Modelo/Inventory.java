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
public class Inventory {
    private int inventory_ID;
    private int film_ID;
    private int store_ID;
    private Timestamp last_update;
           
    public Inventory(){
    this.inventory_ID=0;
    this.film_ID=0;
    this.store_ID=0;
       Date date = new Date();
    this.last_update=new Timestamp(date.getTime());
}
     //________Get&Set_____________
       public void setinventory_ID(int inventory_id){
        this.inventory_ID=inventory_id;
    }
    public int getinventory_ID(){
        return inventory_ID;
    }
    
    public void setstore_ID(int store_id){
        this.store_ID=store_id;
    }
    public int getstore_ID(){
        return store_ID;
    }
    
  
    public void setfilm_ID(int film_id){
        this.film_ID=film_id;
    }
    public int getfilm_ID(){
        return film_ID;
    }
    
    public void setLasUpdate(Timestamp last_Update){
        this.last_update=last_Update;
    }
    public Timestamp getLasUpdate(){
        return last_update;
    }
}

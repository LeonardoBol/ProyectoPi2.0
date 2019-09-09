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
public class Category {
    private int category_id;
    private String category_name;
    private Timestamp last_update;
    //____Constructor__
    public Category(int category_id,String category_name){
    this.category_id=category_id;
    this.category_name=category_name;
     Date date = new Date();
    last_update=new Timestamp(date.getTime());
}
       public Category(){
    this.category_id=0;
    this.category_name="";
       Date date = new Date();
    last_update=new Timestamp(date.getTime());
} 
    
     //________Get&Set_____________
    public void setCategoryid(int category_id){
        this.category_id=category_id;
    }
    public int getCategoryid(){
        return category_id;
    }
    public void setName(String category_name){
        this.category_name=category_name;
    }
    public String getName(){
        return category_name;
    }
   
    public void setLasUpdate(Timestamp last_Update){
        this.last_update=last_Update;
    }
    public Timestamp getLasUpdate(){
        return last_update;
    }
     //________________________
}

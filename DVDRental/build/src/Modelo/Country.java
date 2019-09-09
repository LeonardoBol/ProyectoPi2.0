/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


    import java.sql.Timestamp;
    import java.util.Date;


public class Country {
    

    private int country_id;
    private String country_name;
    private Timestamp last_update;
    //____Constructor__
    
    public Country(int country_id,String country_name){
    this.country_id=country_id;
    this.country_name=country_name;
     Date date = new Date();
    last_update=new Timestamp(date.getTime());
}
    public Country(){
    this.country_id=0;
    this.country_name="";
       Date date = new Date();
    last_update=new Timestamp(date.getTime());
} 
    
     //________Get&Set_____________
    public void setCountryid(int country_id){
        this.country_id=country_id;
    }
    public int getCountryid(){
        return country_id;
    }
    public void setName(String country_name){
        this.country_name=country_name;
    }
    public String getName(){
        return country_name;
    }
   
    public void setLasUpdate(Timestamp last_Update){
        this.last_update=last_Update;
    }
    public Timestamp getLasUpdate(){
        return last_update;
    }
     //________________________  
}

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
public class Addres {
     private int addres_id;
    private String addres;
     private String addres2;
     private String district; 
     private int city_id;
     private String postal_code;
    private String phone;
    private Timestamp last_update;
    
    //____Constructor__
    public Addres(int addres_id,String addres,String addres2, String district,int city_id,String phone,String postal_code){
    this.addres_id=addres_id;
    this.addres=addres;
    this.addres2= addres2;
    this.district=district;
    this.city_id=city_id;
    this.postal_code=postal_code;
    this.phone=phone;
     Date date = new Date();
    last_update=new Timestamp(date.getTime());
}
       public Addres(){
        this.addres_id=0;
    this.addres="";
    this.addres2= "";
    this.district="";
    this.city_id=0;
    this.postal_code="";
    this.phone="";
       Date date = new Date();
    last_update=new Timestamp(date.getTime());
} 
    
     //________Get&Set_____________
    public void setAddresid(int addres_id){
        this.addres_id=addres_id;
    }
    public int getAddresid(){
        return addres_id;
    }
    public void setAddres(String addres){
        this.addres=addres;
    }
    public String getAddres(){
        return addres;
    }
       public void setAddres2(String addres2){
        this.addres2=addres2;
    }
    public String getAddres2(){
        return addres2;
    }
   public void setDistrict(String district){
        this.district=district;
    }
    public String getDistrict(){
        return district;
    }
    public void setCityid(int city_id){
        this.city_id=city_id;
    }
    public int getCityid(){
        return city_id;
    }
    public void setPostalcode(String postal_code){
        this.postal_code=postal_code;
    }
    public String getPostalcode(){
        return postal_code;}
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setLasUpdate(Timestamp last_Update){
        this.last_update=last_Update;
    }
    public Timestamp getLasUpdate(){
        return last_update;
    }
     //________________________  
}

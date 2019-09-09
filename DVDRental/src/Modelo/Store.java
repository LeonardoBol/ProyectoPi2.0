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
public class Store {
          private int store_id;
    private int manager_id;
     private int addres_id;
    private Timestamp last_update;
     
    public Store(int store_id, int manager_id,int addres_id, Timestamp last_update) {
        this.store_id = store_id;
        this.manager_id = manager_id;
        this.addres_id = addres_id;
        this.last_update = last_update;
    }

    public Store(){
        this.store_id=0;
        this.manager_id=0;
        this.addres_id=0;
        Date date = new Date();
        last_update=new Timestamp(date.getTime());
} 

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getAddres_id() {
        return addres_id;
    }

    public void setAddres_id(int addres_id) {
        this.addres_id = addres_id;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
    

}

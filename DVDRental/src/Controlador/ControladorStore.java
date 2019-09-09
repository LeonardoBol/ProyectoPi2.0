/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Store;
import Modelo.StoreDAO;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ControladorStore {
     public static int grabarStore(Store c)
    {
        StoreDAO storeDAO = new StoreDAO();
        int resultado = storeDAO.grabarStore(c);
        return resultado; 
    }
     public static ArrayList<Store> listadoStore(int id)
    {
        ArrayList<Store> listado;
        listado = new ArrayList();
        StoreDAO store = new StoreDAO();
        listado = store.listadoStores(id);
        return listado; 
    }
      public static int borrarStore(int id)
    {
       StoreDAO storeDAO = new StoreDAO();
        int resultado = storeDAO.borrarStore(id);
        return resultado; 
    }
           public static int modificarStore(Store c)
    {
        StoreDAO storeDAO = new StoreDAO();
        int resultado =storeDAO.modificarStore(c);
        return resultado; 
    } 
}

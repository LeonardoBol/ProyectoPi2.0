/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inventory;
import Modelo.InventoryDAO;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ControladorInventory {
           public static int grabarInventory(Inventory c)
    {
        InventoryDAO inventoryDAO = new InventoryDAO();
        int resultado = inventoryDAO.grabarInventory(c);
        return resultado; 
    }
     public static ArrayList<Inventory> listadoInventory(int id)
    {
        ArrayList<Inventory> listado;
        listado = new ArrayList();
        InventoryDAO inventory = new InventoryDAO();
        listado = inventory.listadoInventory(id);
        return listado; 
    }
      public static int borrarActor(int id)
    {
       InventoryDAO inventoryDAO = new InventoryDAO();
        int resultado = inventoryDAO.borrarInventory(id);
        return resultado; 
    }
           public static int modificarInventory(Inventory c)
    {
        InventoryDAO inventoryDAO = new InventoryDAO();
        int resultado =inventoryDAO.modificarInventory(c);
        return resultado; 
    } 
}

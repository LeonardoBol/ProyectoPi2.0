/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Addres;
import Modelo.AddresDAO;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ControladorAddres {
    public static int grabarAddres(Addres c)
    {
        AddresDAO DAO = new AddresDAO();
        int resultado = DAO.grabarAddres(c);
        return resultado; 
    }
     public static ArrayList<Addres> listadoAddres(int id)
    {
        ArrayList<Addres> listado;
        listado = new ArrayList();
        AddresDAO addres = new AddresDAO();
        listado = addres.listadoAddres(id);
        return listado; 
    }
      public static int borrarAddres(int id)
    {
       AddresDAO actorDAO = new AddresDAO();
        int resultado = actorDAO.borrarAddres(id);
        return resultado; 
    }
           public static int modificarAddres(Addres c)
    {
        AddresDAO DAO = new AddresDAO();
        int resultado =DAO.modificarAddres(c);
        return resultado; 
    } 
}

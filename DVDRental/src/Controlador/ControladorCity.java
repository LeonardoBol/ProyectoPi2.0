/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.City;
import Modelo.CityDAO;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ControladorCity {
       public static int grabarCity(City c)
    {
        CityDAO cityDAO = new CityDAO();
        int resultado = cityDAO.grabarCity(c);
        return resultado; 
    }
     public static ArrayList<City> listadoCity(int id)
    {
        ArrayList<City> listado;
        listado = new ArrayList();
        CityDAO cities = new CityDAO();
        listado = cities.listadoCities(id);
        return listado; 
    }
      public static int borrarCity(int id)
    {
       CityDAO cityDAO = new CityDAO();
        int resultado = cityDAO.borrarCity(id);
        return resultado; 
    }
           public static int modificarCity(City c)
    {
        CityDAO cityDAO = new CityDAO();
        int resultado =cityDAO.modificarCity(c);
        return resultado; 
    } 
}

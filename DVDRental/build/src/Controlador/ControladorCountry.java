/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Country;
import Modelo.CountryDAO;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ControladorCountry {
    public static int grabarCountry(Country c)
    {
        CountryDAO countryDAO = new CountryDAO();
        int resultado = countryDAO.grabarPais(c);
        return resultado; 
    }
     public static ArrayList<Country> listadoCountry(int id)
    {
        ArrayList<Country> listado;
        listado = new ArrayList();
        CountryDAO country = new CountryDAO();
        listado = country.listadoCountry(id);
        return listado; 
    }
      public static int borrarCountry(int id)
    {
        CountryDAO countryDAO = new CountryDAO();
        int resultado = countryDAO.borrarCountry(id);
        return resultado; 
    }
           public static int modificarCountry(Country c)
    {
        CountryDAO countryDAO = new CountryDAO();
        int resultado =countryDAO.modificarCountry(c);
        return resultado; 
    }
}

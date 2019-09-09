/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Lenguaje;
import Modelo.LenguajeDAO;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ControladorLenguaje {
    public static int grabarLenguaje(Lenguaje c)
    {
        LenguajeDAO categoryDAO = new LenguajeDAO();
        int resultado = categoryDAO.grabarLenguaje(c);
        return resultado; 
    }
     public static ArrayList<Lenguaje> listadoLenguaje(int id)
    {
        ArrayList<Lenguaje> listado;
        listado = new ArrayList();
        LenguajeDAO lenguajes = new LenguajeDAO();
        listado = lenguajes.listadolenguajes(id);
        return listado; 
    }
      public static int borrarLenguaje(int id)
    {
        LenguajeDAO lenguajeDAO = new LenguajeDAO();
        int resultado = lenguajeDAO.borrarLenguaje(id);
        return resultado; 
    }
           public static int modificarLenguaje(Lenguaje c)
    {
        LenguajeDAO lenguajeDAO = new LenguajeDAO();
        int resultado =lenguajeDAO.modificarLenguaje(c);
        return resultado; 
    }
}

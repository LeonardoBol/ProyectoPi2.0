/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Actor;
import Modelo.ActorDAO;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ControladorActor {
       public static int grabarActor(Actor c)
    {
        ActorDAO actorDAO = new ActorDAO();
        int resultado = actorDAO.grabarActor(c);
        return resultado; 
    }
     public static ArrayList<Actor> listadoActor(int id)
    {
        ArrayList<Actor> listado;
        listado = new ArrayList();
        ActorDAO actores = new ActorDAO();
        listado = actores.listadoActores(id);
        return listado; 
    }
      public static int borrarActor(int id)
    {
       ActorDAO actorDAO = new ActorDAO();
        int resultado = actorDAO.borrarActor(id);
        return resultado; 
    }
           public static int modificarActor(Actor c)
    {
        ActorDAO actorDAO = new ActorDAO();
        int resultado =actorDAO.modificarActor(c);
        return resultado; 
    } 
}

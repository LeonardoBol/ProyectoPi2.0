package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Modelo.CategoryDAO;
import Modelo.Category;
import Vista.CategoryGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class ControladorCategory {
    
        public static int grabarCategory(Category c)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        int resultado = categoryDAO.grabarCategory(c);
        return resultado; 
    }
     public static ArrayList<Category> listadoCategory(int id)
    {
        ArrayList<Category> listado;
        listado = new ArrayList();
        CategoryDAO categorias = new CategoryDAO();
        listado = categorias.listadocategorias(id);
        return listado; 
    }
      public static int borrarCategory(int id)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        int resultado = categoryDAO.borrarCategory(id);
        return resultado; 
    }
           public static int modificarCategory(Category c)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        int resultado =categoryDAO.modificarCategory(c);
        return resultado; 
    }
}

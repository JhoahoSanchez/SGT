package org.example;

import org.dao.CategoriaDAO;

public class App
{
    public static void main( String[] args )
    {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        //categoriaDAO.crearCategoria(new CategoriaEntity(1, "Deberes"));
        //categoriaDAO.actualizarCategoria(1, "Deberes actualizado");
        //CategoriaEntity cat = categoriaDAO.leerCategoria(1);
        //System.out.println(cat.toString());

        categoriaDAO.eliminarCategoria(1);


    }
}

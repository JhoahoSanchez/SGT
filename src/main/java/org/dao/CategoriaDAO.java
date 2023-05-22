package org.dao;

import org.example.CategoriaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CategoriaDAO {

    public void crearCategoria(CategoriaEntity categoria){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(categoria);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Categoria creada");

        }catch (Exception e){
            System.out.println("Error: Categoria no creada");
        }
    }

    public void actualizarCategoria(int id, String descripcion){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            CategoriaEntity categoria = session.get(CategoriaEntity.class, id);
            categoria.setDescripcion(descripcion);
            session.update(categoria);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Categoria actualizada");

        }catch (Exception e){
            System.out.println("Error: Categoria no actualizada");
        }
    }

    public CategoriaEntity leerCategoria(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            CategoriaEntity categoria = session.get(CategoriaEntity.class, id);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Categoria leida");
            return categoria;
        }catch (Exception e){
            System.out.println("Error: Categoria no leida");
        }
        return new CategoriaEntity();
    }

    public void eliminarCategoria(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            CategoriaEntity categoria = session.get(CategoriaEntity.class, id);

            session.delete(categoria);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Categoria eliminada");

        }catch (Exception e){
            System.out.println("Error: Categoria no eliminada");
        }
    }
}

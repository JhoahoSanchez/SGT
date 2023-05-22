package org.dao;

import org.clases.Tarea;
import org.example.TareaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TareaDAO {
    public void crearTarea(TareaEntity tarea){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(tarea);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Tarea creada");

        }catch (Exception e){
            System.out.println("Error: Tarea no creada");
        }
    }

    public void actualizarTarea(int id, String descripcion){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            TareaEntity tarea = session.get(TareaEntity.class, id);
            tarea.setDescripcion(descripcion);
            session.update(tarea);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Tarea actualizada");

        }catch (Exception e){
            System.out.println("Error: Tarea no actualizada");
        }
    }

    public TareaEntity leerTarea(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            TareaEntity tarea = session.get(TareaEntity.class, id);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Tarea leida");
            return tarea;
        }catch (Exception e){
            System.out.println("Error: Tarea no leida");
        }
        return new TareaEntity();
    }

    public void eliminarTarea(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            TareaEntity tarea = session.get(TareaEntity.class, id);

            session.delete(tarea);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Tarea eliminada");

        }catch (Exception e){
            System.out.println("Error: Tarea no eliminada");
        }
    }
}

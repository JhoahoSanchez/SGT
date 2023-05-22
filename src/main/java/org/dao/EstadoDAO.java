package org.dao;

import org.example.EstadoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EstadoDAO {

    public void crearEstado(EstadoEntity estado){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(estado);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Estado creado");

        }catch (Exception e){
            System.out.println("Error: Estado creado");
        }
    }

    public void actualizarEstado(int id, String descripcion){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            EstadoEntity estado = session.get(EstadoEntity.class, id);
            estado.setDescripcion(descripcion);
            session.update(estado);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Estado actualizado");

        }catch (Exception e){
            System.out.println("Error: Estado no actualizado");
        }
    }

    public EstadoEntity leerEstado(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            EstadoEntity estado = session.get(EstadoEntity.class, id);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Categoria leida");
            return estado;
        }catch (Exception e){
            System.out.println("Error: Categoria no leida");
        }
        return new EstadoEntity();
    }

}

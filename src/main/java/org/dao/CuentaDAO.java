package org.dao;

import org.example.CuentaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CuentaDAO {

    public void crearCuenta(CuentaEntity cuenta){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(cuenta);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Cuenta creada");

        }catch (Exception e){
            System.out.println("Error: Cuenta no creada");
        }
    }
/*
    public void actualizarCuenta(int id, String descripcion){
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
    */

    public CuentaEntity leerCuenta(String direccionCorreo){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            CuentaEntity cuenta = session.get(CuentaEntity.class, direccionCorreo);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Cuenta leida");
            return cuenta;
        }catch (Exception e){
            System.out.println("Error: Cuenta no leida");
        }
        return new CuentaEntity();
    }
/*
    public void eliminarCuenta(int id){
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
    */

}

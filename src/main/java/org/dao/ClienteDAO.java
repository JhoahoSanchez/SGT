package org.dao;

import org.example.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClienteDAO {
    public void crearCliente(ClienteEntity clienteEntity){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(clienteEntity);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Cliente creado");

        }catch (Exception e){
            System.out.println("Error: Cliente no creado");
        }
    }

    public void actualizarCorreo(int id, String correo){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            ClienteEntity cliente = session.get(ClienteEntity.class, id);
            cliente.setDireccionCorreo(correo);
            session.update(cliente);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Correo actualizado");

        }catch (Exception e){
            System.out.println("Error: Correo no actualizado");
        }
    }

    public ClienteEntity leerCliente(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            ClienteEntity cliente = session.get(ClienteEntity.class, id);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Cliente leida");
            return cliente;
        }catch (Exception e){
            System.out.println("Error: Cliente no leida");
        }
        return new ClienteEntity();
    }

    public void eliminarCliente(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            ClienteEntity cliente = session.get(ClienteEntity.class, id);

            session.delete(cliente);
            session.getTransaction().commit();
            sessionFactory.close();

            System.out.println("Cliente eliminado");

        }catch (Exception e){
            System.out.println("Error: Cliente no eliminado");
        }
    }
}

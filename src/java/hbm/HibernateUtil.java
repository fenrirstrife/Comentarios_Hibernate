/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {
    /**
     * SessionFactory es literalmente una fábrica de sesiones, cada que una sesión es requerida ésta se crea.
     * ThreadLocal se encarga de generar el hilo de la sesión dentro de nuestra base de datos que nos comunica con el usuario.
     */
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal localSession;
    
    static {
        try {
           Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            /**
             * Es un protocolo para guardar el registro de cada sesion. Contexto "propiedades y atributos que se utlizan"
             */
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
            applySettings(config.getProperties());
            sessionFactory = config.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        localSession = new ThreadLocal();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
        /**
         * Es el inicializador de nuestra sesión simepre que el valor sea "null".
         * @return 
         */
     public static Session getLocalSession() {
        Session session = (Session) localSession.get();
        if (session == null) {
            session = sessionFactory.openSession();
            localSession.set(session);
            System.out.println("\nsesion iniciada");
        }
        return session;
    }
        /**
         * Si la sesion es diferente a "null" entonces se cierra el proceso de nuestra sesión.
         */
     public static void closeLocalSession() {
        Session session = (Session) localSession.get();
        if (session != null) session.close();
        localSession.set(null);
        System.out.println("sesion cerrada\n");
    }
}

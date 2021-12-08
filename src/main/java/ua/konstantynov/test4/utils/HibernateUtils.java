package ua.konstantynov.test4.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ua.konstantynov.test4.entities.Horse;
import ua.konstantynov.test4.entities.Race;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Horse.class);
                configuration.addAnnotatedClass(Race.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

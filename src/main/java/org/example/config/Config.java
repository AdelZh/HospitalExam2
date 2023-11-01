package org.example.config;

import org.example.model.Doctor;
import org.example.model.Hospital;
import org.example.model.Patient;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Config {
    public static SessionFactory getSession() {

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/maven5");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "zoom");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Patient.class);
        configuration.addAnnotatedClass(Hospital.class);
        configuration.addAnnotatedClass(Doctor.class);
        return configuration.buildSessionFactory();
    }
}



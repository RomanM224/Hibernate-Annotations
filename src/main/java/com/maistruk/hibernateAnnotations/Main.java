package com.maistruk.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernateAnnotations.model.Employee;

public class Main {
    
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
                .buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
        Employee employee = new Employee();
      //  employee.setId(0);
        employee.setFirstName("Roman2");
        employee.setLastName("Mai");
        employee.setSalary(1000);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
}

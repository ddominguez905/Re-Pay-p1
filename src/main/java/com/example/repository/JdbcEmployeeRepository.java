package com.example.repository;


import com.example.entity.Employee;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class JdbcEmployeeRepository implements EmployeeRepository {
    
    private static final Logger loggy = Logger.getLogger("ERS");


    EntityManagerFactory EMF;
    public JdbcEmployeeRepository(EntityManagerFactory EMF) {
        this.EMF = EMF;
    }
    //save code
    //find employee by primary key
    @Override
    public Optional<Employee> findById(int emp_id) {
        loggy.info("loading employee: " + emp_id); //LOG for debugging
        EntityManager entityManager = EMF.createEntityManager();
        entityManager.getTransaction().begin();

        Employee employee = EMF.find(Employee.createEntityManager).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        return Optional.empty();
    }

    @Override
    public Employee findByUsername(String username) {
        loggy.info("loading employee: " + username);
        EntityManager entityManager = EMF.createEntityManager();
        entityManager.getTransaction().begin();

        List<Employee> employee = entityManager.createQuery("from Employees").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        return null;
    }

    @Override
    public void update(Employee employee) {
        loggy.info("updating employee: " + employee.getEmp_id());
        EntityManager entityManager = EMF.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(employee); //UPDATE

        entityManager.getTransaction().commit();
       entityManager.close();

    }

    @Override
    public void save(Employee employee) {
        loggy.info("saving employee: " + employee);
        EntityManager entityManager = EMF.createEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        entityManager.close();
    }



    @Override
    public void delete(Employee employee) {
        loggy.info("deleting employee: " + employee.getEmp_id());
        EntityManager entityManager = EMF.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.find(Employee.class, employee.getEmp_id()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

       
        
        
        
        // //DELETE
        // EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        // EntityManager entityManager = entityManagerFactory.createEntityManager(); //MANAGED STATE
        // entityManager.getTransaction().begin();

        // entitiyManager.remove(employee); //REMOVE

        //  entityManager.getTransaction().commit();



    


package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import com.example.entity.Reimbursements;

public class JdbcReimbursementsRepository implements ReimbursmentRepository {
    
    private static final Logger loggy = Logger.getLogger("ERS");
    
    EntityManagerFactory EMF;
    public JdbcReimbursementsRepository(EntityManagerFactory EMF) {
        this.EMF = EMF;
    }



    @Override
    public List<Reimbursements> findAll() {
        loggy.info("loading reimbursement requests: " ); //LOG for debugging
        EntityManager entityManager = EMF.createEntityManager();
        entityManager.getTransaction().begin();

        List<Reimbursements> reimbursements = entityManager.createQuery("from Reimbursments").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return reimbursements;
    }

    @Override
    public Reimbursements findById(int request_id) {
        EntityManager entityManager = EMF.createEntityManager();
        entityManager.getTransaction().begin();

        Reimbursements reimbursements = entityManager.find(Reimbursements.class, request_id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return reimbursements;
    }
    
    @Override
    public void save(Reimbursements reimbursement) {
            loggy.info("saving record: " + reimbursement);
            EntityManager entityManager = EMF.createEntityManager();
            entityManager.getTransaction().begin();
            
            entityManager.persist(reimbursement);
    
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    @Override
    public void delete(int request_id) {
        EntityManager entityManager = EMF.createEntityManager();
        entityManager.getTransaction().begin();

       entityManager.remove(entityManager.find(Reimbursements.class, request_id));

        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
}
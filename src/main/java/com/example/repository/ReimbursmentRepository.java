package com.example.repository;

import java.util.List;

import com.example.entity.Reimbursements;

public interface ReimbursmentRepository {
    void save(Reimbursements reimbursement);
    List<Reimbursements> findAll();
    Reimbursements findById(int request_id);
    void delete(int request_id);
    
}

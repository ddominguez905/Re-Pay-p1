package com.example.repository;

import com.example.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findById(int emp_id);
    Employee findByUsername(String username);
    void update (Employee employee);
    void save (Employee employee);
    void delete (Employee employee);
   

}

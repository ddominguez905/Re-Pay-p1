package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class AuthenticationServiceImpl implements AuthenticationService {

    EmployeeRepository employeeRepository;

    public AuthenticationServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Employee employee = employeeRepository.findByUsername(username);
        if (username == null)
            return false;
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), employee.getPasswords());
        if (result.verified) {
            return true;
        }
        return false;
    }

    @Override
    public void register(String username, String password) {
        Employee employee = new Employee();
        employee.setUsername(username);
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        employee.setPasswords(bcryptHashString);
        employeeRepository.save(employee);
    }


}


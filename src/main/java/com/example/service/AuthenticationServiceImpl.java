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
        System.out.println(employee);
        System.out.println(username);
        if (employee == null)
            return false;

        return password.equals(employee.getPasswords());
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


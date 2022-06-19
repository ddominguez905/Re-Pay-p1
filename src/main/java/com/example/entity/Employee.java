package com.example.entity;

//Fields that map to database
public class Employee {
    private int emp_id;
    private String firstName;
    private String lastName;
    private String username;
    private String passwords;
    private Emp_Role role;

    public Employee(int emp_id, String firstName, String lastName, String username, String passwords, Emp_Role role) {
        this.emp_id = emp_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.passwords = passwords;
        this.role = role;
    }
    public Employee(){
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Emp_Role getRole() {
        return role;
    }

    public void setRole(Emp_Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return passwords.equals(employee.passwords);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "emp_id=" + emp_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }

}





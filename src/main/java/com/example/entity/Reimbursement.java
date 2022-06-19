package com.example.entity;

import java.util.Date;

//Fields that map to database
public class Reimbursement {
    private int requestId;
    private int emp_id;
    private String firstname;
    private String lastname;
    private double expenseAmount;
    Date submitted;
    Date resolved;
    re_Status status;
    String description;


    public Reimbursement(int requestId, int emp_id, String firstname, String lastname, double expenseAmount, Date submitted, Date resolved, re_Status status, String description) {
        super();
        this.requestId = requestId;
        this.emp_id = emp_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.expenseAmount = expenseAmount;
        this.requestId = requestId;
        this.submitted = new Date(System.currentTimeMillis());
        this.resolved = resolved;
        this.status = re_Status.APPROVED;
        this.description = description;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public re_Status getStatus() {
        return status;
    }

    public void setStatus(re_Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "reimbursement{" +
                "emp_id=" + emp_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }

}

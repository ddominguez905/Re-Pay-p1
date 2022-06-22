package com.example.servlet;

import com.example.repository.JdbcEmployeeRepository;
import com.example.service.AuthenticationServiceImpl;
import com.example.service.InvalidCredentialsException;
import com.example.service.UserNotFoundException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    AuthenticationServiceImpl authenticationServiceImpl;



        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("persist");
        JdbcEmployeeRepository employeeRepository = new JdbcEmployeeRepository(EMF);
    {
        authenticationServiceImpl = new AuthenticationServiceImpl(employeeRepository);
    }





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // instantiate a session objection
        HttpSession session = req.getSession();

            
        //input
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
        boolean b = authenticationServiceImpl.authenticate(username, password); 
        
        //process 
            if (!b) {
            resp.sendRedirect("login.html");
            } else {
                session = req.getSession();
                session.setAttribute("employee", username);
                session.setAttribute("employee", password);
                resp.sendRedirect("EmployeeHomepage.html");
            } 
        }catch(UserNotFoundException | InvalidCredentialsException e){
            resp.sendRedirect("/login.html");

        }
    
    }
}


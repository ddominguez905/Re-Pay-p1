package com.example.web;

import com.example.repository.JdbcEmployeeRepository;
import com.example.service.AuthenticationServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/index"})
public class LoginServlet extends HttpServlet {

    AuthenticationServiceImpl authenticationServiceImpl;

   public void init() {
    EntityManagerFactory EMF = Persistence.createEntityManagerFactory("persist");
    JdbcEmployeeRepository employeeRepository = new JdbcEmployeeRepository(EMF);
    AuthenticationServiceImpl authenticationServiceImpl = new AuthenticationServiceImpl(employeeRepository);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // System.out.println(req.getParameter("username"));
        // System.out.println(req.getParameter("password"));
            
        //input
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean b = authenticationServiceImpl.authenticate(username, password);
        
        //process 
        if (!b) {
            req.setAttribute("employee", username);
            resp.sendRedirect("WEB-INF/master-page.jsp>");
        } else {
            HttpSession session = req.getSession();

            session.setAttribute("current-user", username);
            resp.sendRedirect("index.html");
        }

    }

}

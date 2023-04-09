/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.model.FirstTimeModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class LoginManagerServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // accept username and password
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
        //database
//        try{
            // open connection
//            Class.forName("org.postgresql.Driver");
//            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/admission");
//            Statement stm = con.createStatement();
//            ResultSet rs = stm.executeQuery("select * from firsttimemodel where firstemail='"+email+"' and firstpassword='"+password+"'");
            FirstTimeModel user = (FirstTimeModel) session.createQuery("FROM FirstTimeModel WHERE firstEmail = :firstEmail  AND firstPassword = :firstPassword")
            .setParameter("firstEmail", email)
            .setParameter("firstPassword", password)
            .uniqueResult();
     System.out.println(user.getFirstEmail()); 
//            if(rs.next()){
            if(user != null){
                HttpSession sess = request.getSession(true);
                sess.setAttribute("userId", Long.valueOf(user.getId()));
                request.getSession().setAttribute("email", email);
                response.sendRedirect("admission.html");
                
               
                
            }else{
                out.println("<center><h1>Wrong email or password.....</h1></center>");
//                response.sendRedirect("LoginAdmission_EN.html");
            }
            
            //close connection
            session.close();
//            con.close();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
    }

    
    

}

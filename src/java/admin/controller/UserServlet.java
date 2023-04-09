/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.model.StudentAdmissionModel;
import admin.services.StudentAdmissionService;
import admin.services.StudentServiceInterfaceAdmission;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author princecalvinsagatwa
 */
@MultipartConfig
public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //feth form value
           String fName=request.getParameter("firstName");
            String lName=request.getParameter("lastName");
            String pName=request.getParameter("parentName");
            String gender=request.getParameter("gender");
            String phone=request.getParameter("phoneNumber");
            String email=request.getParameter("email");
            String faculty=request.getParameter("faculty");
            String program=request.getParameter("program");
            String nationality=request.getParameter("nationality");
            
            byte[] pic;
            byte[] pdf;
            
            Part picpart = request.getPart("image");
            Part pdfpart = request.getPart("pdf");
            
            InputStream pictureContent = picpart.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[2046];
            int x = 0;
            while((pictureContent.read(buf))!= -1){
            output.write(buf);
            }
            pic = output.toByteArray();
            
            InputStream pdfContent = pdfpart.getInputStream();
            ByteArrayOutputStream outi = new ByteArrayOutputStream();
            byte[] buff = new byte[2046];
            int y = 0;
            while((pdfContent.read(buf))!= -1){
            outi.write(buff);
            }
            pdf = outi.toByteArray();
           
      		//create instance object of the SendEmail Class
           SendEmail sm = new SendEmail();
      		//get the 6-digit code
           String code = sm.getRandom();
           
      		//craete new user using all information
           StudentAdmissionModel user = new StudentAdmissionModel(fName, lName, pName, gender, phone, email, faculty, program, nationality, code,pdf,pic);
           StudentServiceInterfaceAdmission studService= new StudentAdmissionService();
            studService.saveStudent(user);
           //call the send email method
           boolean test = sm.sendEmail(user);
           
      		//check if the email send successfully
           if(test){
               HttpSession session  = request.getSession();
               session.setAttribute("authcode", user);
//               response.sendRedirect("Check.html");
               out.println(lName + " You have successfully registered. Have a productive day!!!!!!");
           }else{
//      		  out.println("Failed to send verification email");
//                  HttpSession session  = request.getSession(false);
//                  session.invalidate();
//                  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//                  response.setHeader("Pragma", "no-cache");
//                  response.setHeader("Expires", "0");
//                  response.sendRedirect("LoginAdmission_EN.html");
//                  out.println("<center><h1>Failed to send verification email.....</h1></center>");
                  out.println("<center><h1>Failed to send email.....</h1></center>");
      	   }
           
        }
    }

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
}

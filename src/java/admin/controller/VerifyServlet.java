/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.model.StudentAdmissionModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author princecalvinsagatwa
 */
public class VerifyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            StudentAdmissionModel user= (StudentAdmissionModel) session.getAttribute("authcode");
            
            String code = request.getParameter("authcode");
            
            if(code.equals(user.getCode())){
                out.println("Verification Done");
            }else{
                out.println("<center><h1>Incorrect verification code.....</h1></center>");
//                  HttpSession sessionz  = request.getSession(false);
//                  sessionz.invalidate();
//                  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//                  response.setHeader("Pragma", "no-cache");
//                  response.setHeader("Expires", "0");
//                  response.sendRedirect("LoginAdmission_EN.html");
            }
            
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

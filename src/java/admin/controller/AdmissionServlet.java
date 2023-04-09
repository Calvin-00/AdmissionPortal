/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.model.StudentAdmissionModel;
import admin.services.StudentAdmissionService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.services.StudentServiceInterfaceAdmission;

/**
 *
 * @author princecalvinsagatwa
 */
public class AdmissionServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fName=request.getParameter("firstName");
            String lName=request.getParameter("lastName");
            String pName=request.getParameter("parentName");
            String gender=request.getParameter("gender");
            String phone=request.getParameter("phoneNumber");
            String faculty=request.getParameter("faculty");
            String program=request.getParameter("program");
            String marital=request.getParameter("maritalstatus");
            String nationality=request.getParameter("nationality");
            
//            StudentAdmissionModel stud=new StudentAdmissionModel(fName, lName, pName, gender, phone, faculty, program, marital, nationality);
            StudentServiceInterfaceAdmission studentService=new StudentAdmissionService();
//            studentService.saveStudent(stud);
            
            
            
//            out.println("http://localhost:23667/AdmissionPortal/Prince123.html");
            out.println("Student registered successfully!!!");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.services;


import admin.dao.StudentAdmissionDao;
import admin.model.StudentAdmissionModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class StudentAdmissionService extends UnicastRemoteObject implements StudentServiceInterfaceAdmission{

    public StudentAdmissionService() throws RemoteException{
        super();
    }
    @Override
    public void saveStudent(StudentAdmissionModel student) throws RemoteException {
        StudentAdmissionDao studentDao=new StudentAdmissionDao();
        studentDao.createStudent(student);
    }
    
     @Override
    public void updateStudent(StudentAdmissionModel student) throws RemoteException {
        StudentAdmissionDao studentDao=new StudentAdmissionDao();
        studentDao.updateStudent(student);
    }
    
}

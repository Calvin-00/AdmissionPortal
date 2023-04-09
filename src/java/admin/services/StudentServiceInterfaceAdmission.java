/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.services;


import admin.model.StudentAdmissionModel;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface StudentServiceInterfaceAdmission extends Remote{
    public void saveStudent(StudentAdmissionModel student) throws RemoteException;
     public void updateStudent(StudentAdmissionModel student) throws RemoteException;
}

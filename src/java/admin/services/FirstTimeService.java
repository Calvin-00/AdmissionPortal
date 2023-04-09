/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.services;

import java.rmi.server.UnicastRemoteObject;
import admin.dao.FirstTimeDao;
import admin.model.FirstTimeModel;
import java.rmi.RemoteException;

public class FirstTimeService extends UnicastRemoteObject implements FirstTimeInterface{
    public FirstTimeService() throws RemoteException{
        super();
    }
    @Override
    public void saveStudent(FirstTimeModel student) throws RemoteException {
        FirstTimeDao studentDao=new FirstTimeDao();
        studentDao.createStudent(student);
    }
    
     @Override
    public void updateStudent(FirstTimeModel student) throws RemoteException {
        FirstTimeDao studentDao=new FirstTimeDao();
        studentDao.updateStudent(student);
    }
}

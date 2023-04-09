/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.services;

import admin.model.FirstTimeModel;
import java.rmi.RemoteException;

/**
 *
 * @author princecalvinsagatwa
 */
public interface FirstTimeInterface {
    public void saveStudent(FirstTimeModel student) throws RemoteException;
    public void updateStudent(FirstTimeModel student) throws RemoteException;
}

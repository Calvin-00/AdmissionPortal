/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.model.FirstTimeModel;
import org.hibernate.*;

public class FirstTimeDao {
    public boolean createStudent(FirstTimeModel student) {
        boolean result=false;
        Session session=FactoryManager.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
        result=Boolean.TRUE;
        return result;
    }

    public boolean updateStudent(FirstTimeModel student) {
        boolean result=false;
        Session session=FactoryManager.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
        result=Boolean.TRUE;
        return result;
    }
}

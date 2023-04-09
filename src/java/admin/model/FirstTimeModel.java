/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FirstTimeModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String firstEmail;
    private String firstPassword;
    private String firstPasswordAgain;

    public FirstTimeModel() {
    }

    public FirstTimeModel(String firstEmail, String firstPassword, String firstPasswordAgain) {
        this.firstEmail = firstEmail;
        this.firstPassword = firstPassword;
        this.firstPasswordAgain = firstPasswordAgain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getFirstEmail() {
        return firstEmail;
    }

    public void setFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    public String getFirstPasswordAgain() {
        return firstPasswordAgain;
    }

    public void setFirstPasswordAgain(String firstPasswordAgain) {
        this.firstPasswordAgain = firstPasswordAgain;
    }

    
    
}

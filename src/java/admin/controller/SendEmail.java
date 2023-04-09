/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.model.StudentAdmissionModel;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author princecalvinsagatwa
 */
public class SendEmail {
    //generate vrification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendEmail(StudentAdmissionModel user) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "cs@wakaglobal.com";
        String password = "Auca@2021";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
//            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.put ("mail.smtp.host", "smtp.gmail.com");
//            pr.setProperty("mail.smtp.port", "587");
            pr.put ("mail.smtp.port ", "587" );
//            pr.setProperty("mail.smtp.auth", "true");
            pr.put ("mail.smtp.auth", "true");
//            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put ("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
             
        
        
        
 
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

    		//set from email address
            mess.setFrom(new InternetAddress(fromEmail));
    		//set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
    		
    		//set email subject
            mess.setSubject(user.getFirstName()+"'s successfull registration");
            
    		//set message text
            mess.setText("Registered successfully.Thanks for coming for registration " + user.getLastName()+ " "+user.getFirstName());
            //send the message
            Transport.send(mess);
            
            test=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
}

    
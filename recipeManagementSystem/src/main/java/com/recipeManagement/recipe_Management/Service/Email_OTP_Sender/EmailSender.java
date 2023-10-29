package com.recipeManagement.recipe_Management.Service.Email_OTP_Sender;

import com.recipeManagement.recipe_Management.Model.User;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import java.net.Authenticator;
import java.util.Properties;

public class EmailSender {

    User user;

    private static final String EMAIL_USERNAME = "jaikisingh302@gmail.com";
    private static final String EMAIL_PASSWORD = "xmvr tutk mfof vppq";

    public static boolean sendEmail(String toEmail, String subject, String body){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body + "  Don't Share this otp with anyone");

            Transport.send(message);
            System.out.println("OTP sent successfully to " + toEmail +" Successfully!!!");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}

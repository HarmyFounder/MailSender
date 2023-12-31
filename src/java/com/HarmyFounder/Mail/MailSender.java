package com.HarmyFounder.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    public static void main(String[] args) {

        final String from = "ofbrick121@gmail.com";
        String to = "abdulyrich@gmail.com";
        String host = "smtp.gmail.com";
        String smtpPort = "465";

        Properties properties = new Properties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(
                properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, "nnmtuzrzseynnkxi");
                    }
                }
        );
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Message Tag");
            message.setText("Message Text");
            Transport.send(message);
        } catch(Exception e) {
            e.printStackTrace();

        }

    }
}

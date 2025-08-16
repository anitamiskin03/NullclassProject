package util;


import java.util.Properties;
import java.net.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.PasswordAuthentication;

public class EmailSender {

	public static void sendEmail(String subject, String body) {
		final String username = "testdemo8898@gmail.com";      // Your email
        final String password = "pdinjatqswdchgiz";         // App password or your email password
        
        Properties props=new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testdemo8898@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient@example.com"));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("Notification email sent.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

		
		
	

}

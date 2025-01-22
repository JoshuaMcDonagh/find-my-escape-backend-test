package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.EmailContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailMessageServiceImpl implements EmailMessageService{
    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    EmailContent emailContent;

    public EmailMessageServiceImpl() {
        emailContent = new EmailContent();
    }

    private void sendEmailMessage(String userEmailAddress, String userName, String subject, String body) {
        emailContent.setUserName(userName);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(userEmailAddress);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);
            System.out.println("Email sent successfully.");

        } catch(Exception e) {
            System.out.println("Error sending email.");
            e.printStackTrace();

        }

    }

    @Override
    public void sendWelcomeEmail(String userEmailAddress, String userName) {
        sendEmailMessage(
                userEmailAddress,
                userName,
                emailContent.getWelcomeSubject(),
                emailContent.getWelcomeBody()
        );
    }

    @Override
    public void sendChangeOfDetailsEmail(String userEmailAddress, String userName) {
        sendEmailMessage(
                userEmailAddress,
                userName,
                emailContent.getChangeOfDetailsSubject(),
                emailContent.getChangeOfDetailsBody()
        );
    }

    @Override
    public void sendAccountDeletionEmail(String userEmailAddress, String userName) {
        sendEmailMessage(
                userEmailAddress,
                userName,
                emailContent.getDeletionSubject(),
                emailContent.getDeletionBody()
        );
    }

}

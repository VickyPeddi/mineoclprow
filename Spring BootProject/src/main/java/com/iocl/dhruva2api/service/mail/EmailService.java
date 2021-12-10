package com.iocl.dhruva2api.service.mail;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleMessage(String from, String to, String[] cc, String subject, String body,
            boolean mailToBeSent) {
        if (!mailToBeSent) {
            to = "aakashjar@outlook.com";
            for (int i = 0; i < cc.length; i++) {
                cc[i] = "aakashjar@outlook.com";
            }
        }
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            if (cc != null)
                helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(body, true);
            emailSender.send(message);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void sendAttachmentMail(String from, String to, String[] cc, String subject, String body,
            String attachmentFilename, DataSource dataSource, boolean mailToBeSent) {
        if (!mailToBeSent) {
            to = "aakashjar@outlook.com";
            for (int i = 0; i < cc.length; i++) {
                cc[i] = "aakashjar@outlook.com";
            }
        }
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            if (cc != null)
                helper.setCc(cc);
            helper.setSubject(subject);
            helper.addAttachment(attachmentFilename, dataSource);
            helper.setText(body, true);
            emailSender.send(message);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
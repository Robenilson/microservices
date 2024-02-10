package com.ms.email.services;

import com.ms.email.emuns.StatusEmail;
import com.ms.email.model.EmailModel;
import com.ms.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailServicer {

    final EmailRepository emailRepository;

    final JavaMailSender javaMailSender;

    public EmailServicer(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    @Value( "${spring.mail.username}")
    private  String emailFrom;

    @Transactional
    public EmailModel sendEmail( EmailModel emailModel){
        try{
            emailModel.setLocalDateTime(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);
            SimpleMailMessage  simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setTo(emailModel.getEmailTO());
            simpleMailMessage.setSubject(emailModel.getSubject());
            simpleMailMessage.setText(emailModel.getText());
            this.javaMailSender.send(simpleMailMessage);
            emailModel.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return this.emailRepository.save(emailModel);
        }
    }


}

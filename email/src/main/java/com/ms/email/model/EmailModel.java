package com.ms.email.model;

import com.ms.email.emuns.StatusEmail;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
public class EmailModel implements Serializable {

    private  static  final Long serialVersionUIO = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailID;



    private UUID userID;
    private  String emailFrom;
    private  String emailTO;
    private   String subject;
    @Column(columnDefinition = "TEXT")
    private   String text;
    private LocalDateTime localDateTime;
    private StatusEmail statusEmail;


    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }

    public UUID getEmailID() {
        return emailID;
    }

    public void setEmailID(UUID emailID) {
        this.emailID = emailID;
    }

    public String getEmailTO() {
        return emailTO;
    }

    public void setEmailTO(String emailTO) {
        this.emailTO = emailTO;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}

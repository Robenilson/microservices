package com.ms.email.consumers;


import com.ms.email.model.EmailModel;
import com.ms.email.record.EmailRecordDTO;
import com.ms.email.services.EmailServicer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    final EmailServicer emailServicer;

    public EmailConsumer(EmailServicer emailServicer) {
        this.emailServicer = emailServicer;
    }

    @RabbitListener(queues= "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDTO,emailModel);
        emailServicer.sendEmail(emailModel);


    }

}

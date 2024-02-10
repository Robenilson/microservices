package com.ms.user.producers;


import com.ms.user.models.UserModel;
import com.ms.user.record.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
     final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;


    public  void  publishMessegeEmail (UserModel userModel){
        var emailDTO= new EmailDTO();
        emailDTO.setEmailTO(userModel.getEmail());
        emailDTO.setUserID(userModel.getUserID());
        emailDTO.setSubject("Cadastro realizado com Sucesso");
        emailDTO.setText("Seja bem-vindo"+ userModel.getName());


        rabbitTemplate.convertAndSend("",routingKey,emailDTO);
    }


}

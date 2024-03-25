package com.ms.email.consumer;

import com.ms.email.dto.EmailDto;
import com.ms.email.model.Email;
import com.ms.email.service.IEmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    IEmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto){
        Email email = emailService.sendEmail(emailDto);
        System.out.println("Email Status: " + email.getStatusEmail());
    }

}

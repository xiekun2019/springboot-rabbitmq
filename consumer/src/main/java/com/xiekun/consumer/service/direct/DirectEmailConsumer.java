package com.xiekun.consumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"email.direct.queue"})
@Component
public class DirectEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("The message received by DirectEmailConsumer is: " + message);
    }
}

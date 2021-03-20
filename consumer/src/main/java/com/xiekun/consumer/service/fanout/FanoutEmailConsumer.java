package com.xiekun.consumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"email.fanout.queue"})
@Component
public class FanoutEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("The message received by FanoutEmailConsumer is: " + message);
    }
}

package com.xiekun.consumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"sms.fanout.queue"})
@Component
public class FanoutSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("The message received by FanoutSMSConsumer is: " + message);
    }
}

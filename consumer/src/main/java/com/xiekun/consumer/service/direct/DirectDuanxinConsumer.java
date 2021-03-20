package com.xiekun.consumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"duanxin.direct.queue"})
@Component
public class DirectDuanxinConsumer {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("The message received by DirectDuanxinConsumer is: " + message);
    }
}

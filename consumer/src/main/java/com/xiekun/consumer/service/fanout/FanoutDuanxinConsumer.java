package com.xiekun.consumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"duanxin.fanout.queue"})
@Component
public class FanoutDuanxinConsumer {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("The message received by FanoutDuanxinConsumer is: " + message);
    }
}

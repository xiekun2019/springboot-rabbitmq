package com.xiekun.consumer.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "com.#"
))
@Component
public class TopicSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("The message received by TopicSMSConsumer is: " + message);
    }
}

package com.xiekun.consumer.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "email.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "*.email.#"
))
@Component
public class TopicEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("The message received by TopicEmailConsumer is: " + message);
    }
}

package com.xiekun.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class DeadRabbitmqConfiguration {

    // 声明死信交换机
    @Bean
    public DirectExchange deadExchange(){
        return new DirectExchange("dead_direct_exchange", true, false);
    }

    // 声明死信队列
    @Bean
    public Queue deadQueue() {
        return new Queue("dead.direct.queue", true);
    }

    @Bean
    public Binding deadBinding(){
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("dead");
    }

}

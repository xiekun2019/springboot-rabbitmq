package com.xiekun.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class TTLRabbitmqConfiguration {
    // 声明注册ttl模式的交换机
    @Bean
    public DirectExchange ttlExchange(){
        return new DirectExchange("ttl_order_exchange", true, false);
    }

    // 声明队列 sms.ttl.queue email.ttl.queue duanxin.ttl.queue
    @Bean
    public Queue ttlSmsQueue() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        // 设置死信交换机
        args.put("x-dead-letter-exchange", "dead_direct_exchange");
        // 设置死信路由key，fanout 模式不需要配置
        args.put("x-dead-letter-routing-key", "dead");
        return new Queue("sms.ttl.queue", true, false, false, args);
    }

    // 声明队列 sms.ttl.queue email.ttl.queue duanxin.ttl.queue
    @Bean
    public Queue ttlMessageQueue() {
        return new Queue("ttl.message.queue", true);
    }


    // 完成绑定关系，队列和交换机绑定
    @Bean
    public Binding ttlSmsBinding(){
        return BindingBuilder.bind(ttlSmsQueue()).to(ttlExchange()).with("ttl");
    }

    // 完成绑定关系，队列和交换机绑定
    @Bean
    public Binding ttlMessageBinding(){
        return BindingBuilder.bind(ttlMessageQueue()).to(ttlExchange()).with("ttlMessage");
    }

}

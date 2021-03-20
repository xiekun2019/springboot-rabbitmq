package com.xiekun.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 模拟用户下单
     * @param userId user id
     * @param productId 产品 id
     * @param num 下单数量
     */
    public void makeOrder(String userId, String productId, int num){
        // 根据商品 id 查询库存是否充足

        // 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功，orderId = " + orderId);
        // 通过 mq 类完成消息的分发
        // 参数1：交换机，参数2：路由key/queue队列名称，参数3：消息内容
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";

        rabbitTemplate.convertAndSend(exchangeName, routingKey, userId + " " + productId + " " + num + " " + orderId);
    }

    /**
     * Direct exchange 模拟用户下单
     * @param userId user id
     * @param productId 产品 id
     * @param num 下单数量
     */
    public void makeOrderDirect(String userId, String productId, int num){
        // 根据商品 id 查询库存是否充足

        // 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功，orderId = " + orderId);
        // 通过 mq 类完成消息的分发
        // 参数1：交换机，参数2：路由key/queue队列名称，参数3：消息内容
        String exchangeName = "direct_order_exchange";

        rabbitTemplate.convertAndSend(exchangeName, "email", userId + " " + productId + " " + num + " " + orderId);
        rabbitTemplate.convertAndSend(exchangeName, "duanxin", userId + " " + productId + " " + num + " " + orderId);
    }

    /**
     * Topic exchange 模拟用户下单
     * @param userId user id
     * @param productId 产品 id
     * @param num 下单数量
     */
    public void makeOrderTopic(String userId, String productId, int num){
        // 根据商品 id 查询库存是否充足

        // 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功，orderId = " + orderId);
        // 通过 mq 类完成消息的分发
        // 参数1：交换机，参数2：路由key/queue队列名称，参数3：消息内容
        String exchangeName = "topic_order_exchange";
        String routingKey = "com.email.duanxin";
        // #.duanxin.#
        // *.email.#
        // com.#
        rabbitTemplate.convertAndSend(exchangeName, routingKey, userId + " " + productId + " " + num + " " + orderId);
    }

    /**
     * 模拟用户下单
     * @param userId user id
     * @param productId 产品 id
     * @param num 下单数量
     */
    public void makeOrderTTL(String userId, String productId, int num){
        // 根据商品 id 查询库存是否充足

        // 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功，orderId = " + orderId);
        // 通过 mq 类完成消息的分发
        // 参数1：交换机，参数2：路由key/queue队列名称，参数3：消息内容
        String exchangeName = "ttl_order_exchange";
        String routingKey = "ttl";
        // #.duanxin.#
        // *.email.#
        // com.#
        rabbitTemplate.convertAndSend(exchangeName, routingKey, userId + " " + productId + " " + num + " " + orderId);
    }
}


















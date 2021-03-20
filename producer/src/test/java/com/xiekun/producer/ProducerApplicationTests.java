package com.xiekun.producer;

import com.xiekun.producer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerApplicationTests {
	@Autowired
	private OrderService orderService;

	@Test
	void contextLoads() {
		orderService.makeOrderTopic("1", "1", 12);
	}

	@Test
	void testOrderTopic() {
		orderService.makeOrderTopic("1", "1", 12);
	}

}

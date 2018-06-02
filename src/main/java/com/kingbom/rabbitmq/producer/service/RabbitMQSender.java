package com.kingbom.rabbitmq.producer.service;

import com.kingbom.rabbitmq.producer.model.Transaction;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bombay on 2/6/2018 AD.
 */
@Service
public class RabbitMQSender {

    private final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${kingbom.rabbitmq.exchange}")
    private String exchange;

    @Value("${kingbom.rabbitmq.routingkey}")
    private String routingKey;

    public void send(Transaction transaction) {
        rabbitTemplate.convertAndSend(exchange, routingKey, transaction);
        log.debug("Send transaction id : {} member id : {} ", transaction.getId(), transaction.getMemberId());
    }
}

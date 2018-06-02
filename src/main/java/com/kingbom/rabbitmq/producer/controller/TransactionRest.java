package com.kingbom.rabbitmq.producer.controller;

import com.kingbom.rabbitmq.producer.dto.TransactionRequest;
import com.kingbom.rabbitmq.producer.model.Transaction;
import com.kingbom.rabbitmq.producer.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bombay on 2/6/2018 AD.
 */
@RestController
@RequestMapping("/api")
public class TransactionRest {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/transactions")
    public String producers(@RequestBody Transaction request){
        rabbitMQSender.send(request);
        return "Message sent transaction to the RabbitMQ Successfully";
    }

    @PostMapping("/transactions/multi")
    public String producer(@RequestBody TransactionRequest request){
        request.getTransactions()
                .stream()
                .forEach(transaction -> rabbitMQSender.send(transaction));
        return "Message sent transaction to the RabbitMQ Successfully";
    }
}

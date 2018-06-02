package com.kingbom.rabbitmq.producer.controller;

import com.kingbom.rabbitmq.producer.dto.TransactionRequest;
import com.kingbom.rabbitmq.producer.model.Transaction;
import com.kingbom.rabbitmq.producer.service.TransactionSender;
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
    private TransactionSender transactionSender;

    @PostMapping("/transactions")
    public String producer(@RequestBody Transaction request){
        transactionSender.send(request);
        return "Message sent transaction to the RabbitMQ Successfully";
    }

    @PostMapping("/transactions/multi")
    public String producers(@RequestBody TransactionRequest request){
        request.getTransactions()
                .stream()
                .forEach(transaction -> transactionSender.send(transaction));
        return "Message sent transaction to the RabbitMQ Successfully";
    }
}

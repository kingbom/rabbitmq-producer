package com.kingbom.rabbitmq.producer.service;

import com.kingbom.rabbitmq.producer.controller.TransactionRest;
import com.kingbom.rabbitmq.producer.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by bombay on 2/6/2018 AD.
 */
@Component
public class TransactionScheduler {

    @Autowired
    private TransactionRest transactionRest;

    @Scheduled(fixedDelay = 10000)
    public void process(){
        for (int i=0; i<=100_000;i++){
            Transaction transaction = new Transaction(String.valueOf(i), "1", "9" ,"10"+i, BigDecimal.TEN.add(new BigDecimal(i)));
            transactionRest.producer(transaction);
        }
    }
}

package com.kingbom.rabbitmq.producer.dto;

import com.kingbom.rabbitmq.producer.model.Transaction;

import java.util.List;

/**
 * Created by bombay on 2/6/2018 AD.
 */
public class TransactionRequest {

    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

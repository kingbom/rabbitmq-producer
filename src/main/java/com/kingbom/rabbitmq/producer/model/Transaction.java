package com.kingbom.rabbitmq.producer.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by bombay on 2/6/2018 AD.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Transaction.class)
public class Transaction {

    private String id;

    private String merchantId;

    private String campaignId;

    private String memberId;

    private BigDecimal sumTotal;

    private LocalDateTime txDate = LocalDateTime.now();

    public Transaction() {
    }

    public Transaction(String id, String merchantId, String campaignId, String memberId, BigDecimal sumTotal) {
        this.id = id;
        this.merchantId = merchantId;
        this.campaignId = campaignId;
        this.memberId = memberId;
        this.sumTotal = sumTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(BigDecimal sumTotal) {
        this.sumTotal = sumTotal;
    }

    public LocalDateTime getTxDate() {
        return txDate;
    }

    public void setTxDate(LocalDateTime txDate) {
        this.txDate = txDate;
    }
}

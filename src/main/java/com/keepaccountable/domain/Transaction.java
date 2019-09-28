package com.keepaccountable.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class Transaction {

    private String transactionId;
    private Date timestamp;
    private String description;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String creditDebitIndicator;
    private String type;
    private List<String> categories;
    private String merchantName;
}

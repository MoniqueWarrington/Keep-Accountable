package com.keepaccountable.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Account {

    private String accountId;
    private String accountType;
    private String accountNumber;
    private String currency;
    private String displayName;
    private Date updateTimestamp;
    private Provider provider;
}

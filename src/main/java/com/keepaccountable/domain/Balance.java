package com.keepaccountable.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Balance {

    private String currency;
    private BigDecimal available;
    private BigDecimal current;
    private BigDecimal overdraft;
    private Date updatedTimestamp;
}

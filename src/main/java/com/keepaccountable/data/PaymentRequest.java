package com.keepaccountable.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentRequest {
    private String fromAccount;
    private String toAccount;
    private PaymentRef from;
    private PaymentRef to;
    private BigDecimal amount;
}
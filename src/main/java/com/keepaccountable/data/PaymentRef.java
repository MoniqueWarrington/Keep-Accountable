package com.keepaccountable.data;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class PaymentRef {
    private String particulars;
    private String code;
    private String reference;
}

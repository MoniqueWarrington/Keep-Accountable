package com.keepaccountable.data;

import com.keepaccountable.domain.Balance;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class BalanceResponse {

    private List<Balance> data;
}

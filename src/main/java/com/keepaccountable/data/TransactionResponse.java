package com.keepaccountable.data;

import com.keepaccountable.domain.Transaction;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class TransactionResponse {

    private List<Transaction> data;
}

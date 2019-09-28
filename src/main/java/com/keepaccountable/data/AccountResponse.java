package com.keepaccountable.data;

import com.keepaccountable.domain.Account;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AccountResponse {

    private List<Account> data;
}

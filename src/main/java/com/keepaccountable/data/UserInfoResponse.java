package com.keepaccountable.data;

import com.keepaccountable.domain.UserInfo;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserInfoResponse {
    private List<UserInfo> data;
}

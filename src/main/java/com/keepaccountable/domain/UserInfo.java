package com.keepaccountable.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class UserInfo {

    private List<Address> addresses;
    private Date dateOfBirth;
    private List<String> emails;
    private String fullName;
    private List<String> phones;
    private Date updatedTimestamp;
}

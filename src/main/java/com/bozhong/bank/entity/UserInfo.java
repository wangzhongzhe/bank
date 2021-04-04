package com.bozhong.bank.entity;

import lombok.Data;

@Data
public class UserInfo {
    private String userId;
    private String userName;
    private String pwd;
    private String createTime;
}

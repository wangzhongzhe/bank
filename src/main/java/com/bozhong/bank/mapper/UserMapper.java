package com.bozhong.bank.mapper;

import com.bozhong.bank.entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserInfo getUserById(String userId);
}

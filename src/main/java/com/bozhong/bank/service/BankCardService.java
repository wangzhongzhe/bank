package com.bozhong.bank.service;

import com.bozhong.bank.entity.ReturnMap;

import java.util.Map;

public interface BankCardService {
    Map getBankCardPage(Map map);

    ReturnMap insertBankCardInfo(Map<String, Object> map);
}

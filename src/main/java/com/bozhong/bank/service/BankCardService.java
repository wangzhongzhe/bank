package com.bozhong.bank.service;

import com.bozhong.bank.entity.AssetBankCard;

import java.util.Map;

public interface BankCardService {
    Map getBankCardPage(Map map);

    boolean insertBankCardInfo(AssetBankCard assetBankCard);
}

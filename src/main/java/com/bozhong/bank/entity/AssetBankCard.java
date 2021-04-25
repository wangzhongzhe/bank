package com.bozhong.bank.entity;

import lombok.Data;

@Data
public class AssetBankCard {
    private int id;

    private String cardId;

    private String bank;

    private String accountHolder;

    private String cardType;

    private float fixedDeposit;

    private float currentDeposit;
}

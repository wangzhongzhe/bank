package com.bozhong.bank.entity;

public class AssetBankCard {

    private String cardId;

    private String bank;

    private String accountHolder;

    private String cardType;

    private float fixedDeposit;

    private float currentDeposit;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public float getFixedDeposit() {
        return fixedDeposit;
    }

    public void setFixedDeposit(float fixedDeposit) {
        this.fixedDeposit = fixedDeposit;
    }

    public float getCurrentDeposit() {
        return currentDeposit;
    }

    public void setCurrentDeposit(float currentDeposit) {
        this.currentDeposit = currentDeposit;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
}

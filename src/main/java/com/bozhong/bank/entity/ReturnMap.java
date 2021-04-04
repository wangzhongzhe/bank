package com.bozhong.bank.entity;

import lombok.Data;

@Data
public class ReturnMap {
    private boolean status;

    private String message;

    private String jsonData;

    public ReturnMap() {
        this.status = true;
        this.message = "操作成功";
    }

    public ReturnMap(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}

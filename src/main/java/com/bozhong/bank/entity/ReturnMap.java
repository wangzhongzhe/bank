package com.bozhong.bank.entity;

public class ReturnMap {

    private Boolean status;

    private String message;

    private String jsonData;

    public ReturnMap(){
        this.status = true;
        this.message = "操作成功";
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}

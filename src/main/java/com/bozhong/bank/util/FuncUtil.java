package com.bozhong.bank.util;

import com.bozhong.bank.entity.AssetBankCard;
import com.bozhong.bank.entity.ReturnMap;

import java.util.HashMap;
import java.util.Map;

public class FuncUtil {
    public static ReturnMap getReturnMapFromResult(int result, String successMsg, String failMsg){
        return result > 0 ? new ReturnMap(true, successMsg) : new ReturnMap(false, failMsg);
    }

    public static AssetBankCard getAssetBankCardFromMap(Map<String, Object> map){
        AssetBankCard assetBankCard = new AssetBankCard();
        assetBankCard.setId(Integer.parseInt((String) map.get("id")));
        assetBankCard.setCardId(String.valueOf(map.get("cardId")));
        assetBankCard.setBank(String.valueOf(map.get("bank")));
        assetBankCard.setAccountHolder(String.valueOf(map.get("accountHolder")));
        assetBankCard.setCardType(String.valueOf(map.get("cardType")));
        assetBankCard.setFixedDeposit(Float.parseFloat(String.valueOf(map.get("fixedDeposit"))));
        assetBankCard.setCurrentDeposit(Float.parseFloat(String.valueOf(map.get("currentDeposit"))));
        return assetBankCard;
    }
}

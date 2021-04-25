package com.bozhong.bank.service.impl;

import com.bozhong.bank.entity.AssetBankCard;
import com.bozhong.bank.entity.ReturnMap;
import com.bozhong.bank.mapper.AssetBankCardMapper;
import com.bozhong.bank.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankCardServiceImpl implements BankCardService {
    @Autowired
    private AssetBankCardMapper assetBankCardMapper;

    @Override
    public Map getBankCardPage(Map map) {
        Map<String, Object> ret = new HashMap<>();
//        ReturnMap returnMap = new ReturnMap();
//        Map<String, Object> jsonData = new HashMap<>();
        int total = assetBankCardMapper.getSize(map);
        List<AssetBankCard> bankCardList = assetBankCardMapper.getPage(map);
        ret.put("total", total);
        ret.put("rows", bankCardList);
//        ret.put();
//        ret.put();
//        jsonData.put("data", bankCardList);
//        returnMap.setJsonData(JSONObject.fromObject(jsonData).toString());

        return ret;
    }

    @Override
    public ReturnMap insertBankCardInfo(Map<String, Object> map) {
        AssetBankCard assetBankCard = new AssetBankCard();
        assetBankCard.setCardId(String.valueOf(map.get("cardId")));
        assetBankCard.setBank(String.valueOf(map.get("bank")));
        assetBankCard.setAccountHolder(String.valueOf(map.get("accountHolder")));
        assetBankCard.setCardType(String.valueOf(map.get("cardType")));
        assetBankCard.setFixedDeposit(Float.parseFloat(String.valueOf(map.get("fixedDeposit"))));
        assetBankCard.setCurrentDeposit(Float.parseFloat(String.valueOf(map.get("currentDeposit"))));
        if (assetBankCardMapper.getAssetBankCard(assetBankCard.getCardId()) > 0) {
            return new ReturnMap(false, "此卡号已存在");
        }
        int result = assetBankCardMapper.insertBankCardInfo(assetBankCard);
        return result > 0 ? new ReturnMap(true, "新增成功") : new ReturnMap(false, "新增失败");
    }

    @Override
    public ReturnMap updateBankCardInfo(Map<String, Object> map) {
        return null;
    }

    @Override
    public ReturnMap deleteBankCardInfo(Map<String, Object> map) {
        return null;
    }
}

package com.bozhong.bank.service.impl;

import com.bozhong.bank.entity.AssetBankCard;
import com.bozhong.bank.entity.ReturnMap;
import com.bozhong.bank.mapper.AssetBankCardMapper;
import com.bozhong.bank.mapper.UserMapper;
import com.bozhong.bank.entity.UserInfo;
import com.bozhong.bank.service.BankCardService;
import net.sf.json.JSONObject;
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
}

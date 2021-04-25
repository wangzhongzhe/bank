package com.bozhong.bank.service.impl;

import com.bozhong.bank.entity.AssetBankCard;
import com.bozhong.bank.entity.ReturnMap;
import com.bozhong.bank.mapper.AssetBankCardMapper;
import com.bozhong.bank.service.BankCardService;
import com.bozhong.bank.util.FuncUtil;
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
        AssetBankCard assetBankCard = FuncUtil.getAssetBankCardFromMap(map);
        if (assetBankCardMapper.getAssetBankCard(assetBankCard.getCardId()) > 0) {
            return new ReturnMap(false, "此卡号已存在");
        }
        return FuncUtil.getReturnMapFromResult(assetBankCardMapper.insertBankCardInfo(assetBankCard), "新建成功", "新建失败");
    }

    @Override
    public ReturnMap updateBankCardInfo(Map<String, Object> map) {
        AssetBankCard assetBankCard = FuncUtil.getAssetBankCardFromMap(map);
        return FuncUtil.getReturnMapFromResult(assetBankCardMapper.updateBankCardInfo(assetBankCard), "更新成功", "更新失败");
    }

    @Override
    public ReturnMap deleteBankCardInfo(Map<String, Object> map) {
        String ids = (String) map.get("idList");
        return FuncUtil.getReturnMapFromResult(assetBankCardMapper.deleteBankCardInfo(ids), "删除成功", "删除失败");
    }
}

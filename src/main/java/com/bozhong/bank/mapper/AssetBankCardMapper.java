package com.bozhong.bank.mapper;

import com.bozhong.bank.entity.AssetBankCard;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AssetBankCardMapper {

    public int getSize(Map map);

    public List<AssetBankCard> getPage(Map map);

}

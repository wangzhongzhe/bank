package com.bozhong.bank.mapper;

import com.bozhong.bank.entity.AssetBankCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AssetBankCardMapper {
    int getSize(Map map);

    List<AssetBankCard> getPage(Map map);

    int getAssetBankCard(@Param("cardId") String cardId);

    int insertBankCardInfo(AssetBankCard assetBankCard);

    int updateBankCardInfo(AssetBankCard assetBankCard);

    int deleteBankCardInfo(@Param("ids") String ids);
}

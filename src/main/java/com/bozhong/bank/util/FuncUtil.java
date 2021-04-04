package com.bozhong.bank.util;

import java.util.HashMap;
import java.util.Map;

public class FuncUtil {

    public static Map getReturnMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("message", "操作成功");
        return map;
    }
}

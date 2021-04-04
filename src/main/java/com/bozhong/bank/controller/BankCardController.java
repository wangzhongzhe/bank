package com.bozhong.bank.controller;

import com.bozhong.bank.entity.ReturnMap;
import com.bozhong.bank.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/bank")
public class BankCardController {

    @Autowired
    private BankCardService bankCardService;

    @ResponseBody
    @RequestMapping(value = "/select")
    Map welcome(@RequestParam Map map){
        return bankCardService.getBankCardPage(map);
    }


}

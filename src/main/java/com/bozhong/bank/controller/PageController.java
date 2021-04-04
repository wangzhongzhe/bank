package com.bozhong.bank.controller;

import com.bozhong.bank.entity.ReturnMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value = "/page")
public class PageController {

    @RequestMapping(value = "/bankCard")
    String getBankCardPage() {
        return "bankCard";
    }
}

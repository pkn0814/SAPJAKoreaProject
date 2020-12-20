package com.ja.jademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class StockController {
    @GetMapping("/stock_list")
    public String index(){
        return "stock/stock_list";
    }
}

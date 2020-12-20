package com.ja.jademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @GetMapping("/payment_list")
    public String index(){
        return "payment/payment_list";
    }
}
package com.ja.jademo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/education")
public class EducationController {
    @GetMapping("/education")
    public String index(){
        return "education/education";
    }
}

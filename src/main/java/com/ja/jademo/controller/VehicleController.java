package com.ja.jademo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    @GetMapping("/vehicle_list")
    public String index(){
        return "vehicle/vehicle_list";
    }
}
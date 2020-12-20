
package com.ja.jademo.controller;

import com.ja.jademo.model.User;
import com.ja.jademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AdminformController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/adminform")
    public String form(Model model, @RequestParam(required=false) Long id){
        if (id == null) {
            model.addAttribute("user", new User());
        } else {
            User user = userRepository.findById(id).orElse(null);
            model.addAttribute("user", user);
        }
        return "account/adminform";
    }

    @PostMapping("/adminform")
    public String greetingSubmit(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/account/admin";
    }



}

package com.ja.jademo.controller;

import com.ja.jademo.model.User;
import com.ja.jademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AuthorityTestController {
    /*@GetMapping("/admin")
    public String index(){
        return "account/admin";
    }*/

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String admin(Model model, @RequestParam(required=false) Long id){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        if (id == null) {
            model.addAttribute("user", new User());
        } else {
            User user = userRepository.findById(id).orElse(null);
            model.addAttribute("user", user);
        }
        return "account/admin";
    }

    @PostMapping("/admin")
    public String greetingSubmit(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/account/admin";
    }
}


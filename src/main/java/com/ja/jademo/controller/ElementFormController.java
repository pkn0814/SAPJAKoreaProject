
package com.ja.jademo.controller;

import com.ja.jademo.model.Element;
import com.ja.jademo.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/education")
public class ElementFormController {
    @Autowired
    private ElementRepository elementRepository;

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required=false) Long id){
        if (id == null) {
            model.addAttribute("element", new Element());
        } else {
            Element element = elementRepository.findById(id).orElse(null);
            model.addAttribute("element", element);
        }
        return "education/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute Element element){
        elementRepository.save(element);
        return "redirect:/education/elementary";
    }

}

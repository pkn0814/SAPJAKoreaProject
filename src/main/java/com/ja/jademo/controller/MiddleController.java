package com.ja.jademo.controller;

import com.ja.jademo.model.Element;
import com.ja.jademo.model.Middle;
import com.ja.jademo.repository.MiddleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/education")
public class MiddleController {
    @Autowired
    private MiddleRepository middleRepository;

    @GetMapping("/middle")
    public String middle(Model model ,@RequestParam(required=false) Long id){
        List<Middle> middles = middleRepository.findAll();

        //Page<Middle> middles = middleRepository.findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(searchtext, searchtext, searchtext, searchtext, pageable);
        //int startPage=Math.max(1, middles.getPageable().getPageNumber()-4);
        //int endPage=Math.min(middles.getTotalPages(), middles.getPageable().getPageNumber()+4);
        //model.addAttribute("startPage", startPage);
        //model.addAttribute("endPage", endPage);
        model.addAttribute("middles", middles);
        if (id == null) {
            model.addAttribute("middle", new Middle());
        } else {
            Middle middle = middleRepository.findById(id).orElse(null);
            model.addAttribute("middle", middle);
        }
        return "education/middle";
    }

    @PostMapping("/middle")
    public String greetingSubmit(@ModelAttribute Middle middle){
        middleRepository.save(middle);
        return "redirect:/education/middle";
    }



}
package com.ja.jademo.controller;

import com.ja.jademo.model.Element;
import com.ja.jademo.model.High;
import com.ja.jademo.repository.HighRepository;
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
public class HighController {
    @Autowired
    private HighRepository highRepository;

    @GetMapping("/high")
    public String high(Model model ,@RequestParam(required=false) Long id){
        List<High> highs = highRepository.findAll();

        //Page<High> highs = highRepository.findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(searchtext, searchtext, searchtext, searchtext, pageable);
        //int startPage=Math.max(1, highs.getPageable().getPageNumber()-4);
        //int endPage=Math.min(highs.getTotalPages(), highs.getPageable().getPageNumber()+4);
        //model.addAttribute("startPage", startPage);
        //model.addAttribute("endPage", endPage);
        model.addAttribute("highs", highs);
        if (id == null) {
            model.addAttribute("high", new High());
        } else {
            High high = highRepository.findById(id).orElse(null);
            model.addAttribute("high", high);
        }
        return "education/high";
    }

    @PostMapping("/high")
    public String greetingSubmit(@ModelAttribute High high){
        highRepository.save(high);
        return "redirect:/education/high";
    }



}

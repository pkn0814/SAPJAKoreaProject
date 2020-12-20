package com.ja.jademo.controller;

import com.ja.jademo.model.Middle;
import com.ja.jademo.model.Univ;
import com.ja.jademo.repository.UnivRepository;
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
public class UnivController {
    @Autowired
    private UnivRepository univRepository;

    @GetMapping("/univ")
    public String univ(Model model){
        List<Univ> univs = univRepository.findAll();

        //Page<Univ> univs = univRepository.findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(searchtext, searchtext, searchtext, searchtext, pageable);
        //int startPage=Math.max(1, univs.getPageable().getPageNumber()-4);
        //int endPage=Math.min(univs.getTotalPages(), univs.getPageable().getPageNumber()+4);
        //model.addAttribute("startPage", startPage);
        //model.addAttribute("endPage", endPage);
        model.addAttribute("univs", univs);
        //if (id == null) {
        //    model.addAttribute("univ", new Univ());
        //} else {
        //    Univ univ = univRepository.findById(id).orElse(null);
        //    model.addAttribute("univ", univ);
        //}
        return "education/univ";
    }

    @PostMapping("/univ")
    public String greetingSubmit(@ModelAttribute Univ univ){
        univRepository.save(univ);
        return "redirect:/education/univ";
    }



}

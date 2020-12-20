package com.ja.jademo.controller;

import com.ja.jademo.model.Element;
import com.ja.jademo.model.Middle;
import com.ja.jademo.model.Vehicle;
import com.ja.jademo.repository.ElementRepository;
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
public class ElementController {
    @Autowired
    private ElementRepository elementRepository;

    @GetMapping("/elementary")
    public String elementary(Model model ,@RequestParam(required=false) Long id){
        List<Element> elements = elementRepository.findAll();
        //Page<Element> elements = elementRepository.findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(searchtext, searchtext, searchtext, searchtext);
        //int startPage=Math.max(1, elements.getPageable().getPageNumber()-4);
        //int endPage=Math.min(elements.getTotalPages(), elements.getPageable().getPageNumber()+4);
        //model.addAttribute("startPage", startPage);
        //model.addAttribute("endPage", endPage);
        model.addAttribute("elements", elements);
        if (id == null) {
            model.addAttribute("element", new Element());
        } else {
            Element element = elementRepository.findById(id).orElse(null);
            model.addAttribute("element", element);
        }
        return "education/elementary";
    }
    //public Float getClass_numTotals() {
    //    return elementRepository.selectTotals();
    //}

    @PostMapping("/elementary")
    public String greetingSubmit(@ModelAttribute Element element){
        elementRepository.save(element);
        return "redirect:/education/elementary";
    }




}

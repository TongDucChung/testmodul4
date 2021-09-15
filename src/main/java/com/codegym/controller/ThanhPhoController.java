package com.codegym.controller;

import com.codegym.models.DatNuoc;
import com.codegym.models.ThanhPho;
import com.codegym.service.IDatNuocSerVice;
import com.codegym.service.IThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/home")
public class ThanhPhoController {
    @Autowired
    IThanhPhoService iThanhPhoService;
    @Autowired
    IDatNuocSerVice iDatNuocSerVice;
    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iThanhPhoService.findAll());
        return modelAndView;
    }
    @ModelAttribute("listDatNuoc")
    public ArrayList<DatNuoc>listDatNuoc(){
        return (ArrayList<DatNuoc>) iDatNuocSerVice.findAll();
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("thanhPho", new ThanhPho());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("thanhPho") ThanhPho thanhPho, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        iThanhPhoService.saveNV(thanhPho);
        return new ModelAndView("redirect:/home/show");
    }

    @GetMapping("/Edit/{id}")
    public ModelAndView showEdit(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("Edit");
        modelAndView.addObject("thanhPho", iThanhPhoService.findById(id));
        return modelAndView;
    }

    @PostMapping("/Edit/{id}")
    public ModelAndView Edit(@ModelAttribute ThanhPho thanhPho) {
       iThanhPhoService.saveNV(thanhPho);
        return new ModelAndView("redirect:/home/show");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("ThanhPho", iThanhPhoService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute ThanhPho thanhPho,@PathVariable long id) {
        iThanhPhoService.deleteNV(iThanhPhoService.findById(id));
        return new ModelAndView("redirect:/home/show");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("showDetail");
        modelAndView.addObject("ThanhPho", iThanhPhoService.findById(id));
        return modelAndView;
    }
}

package com.imooc.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Think
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("name","慕课");
        return "index";
    }
}

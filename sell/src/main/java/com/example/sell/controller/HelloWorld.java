package com.example.sell.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public ModelAndView hello(){
        return new ModelAndView("/common/index");
    }
}

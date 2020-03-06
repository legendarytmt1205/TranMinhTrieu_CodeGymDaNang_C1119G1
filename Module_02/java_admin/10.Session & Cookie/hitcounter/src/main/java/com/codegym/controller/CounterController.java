package com.codegym.controller;

import com.codegym.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("count")
public class CounterController {

    /* add MyCounter in model attribute */
    @ModelAttribute("count")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("count") MyCounter tmt) {
        tmt.increment();
        return "index";
    }
}
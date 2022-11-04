package com.baeldung.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "error/accessDenied";
    }

}

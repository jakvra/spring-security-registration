package com.baeldung.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {

    @RequestMapping("/management")
    public String management() {
        return "private/management";
    }

}

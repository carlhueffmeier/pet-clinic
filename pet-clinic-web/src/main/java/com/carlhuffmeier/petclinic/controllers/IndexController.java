package com.carlhuffmeier.petclinic.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }
}

package com.example.viacep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping
    @ResponseBody
    public String index() {
        return "Index";
    }
}

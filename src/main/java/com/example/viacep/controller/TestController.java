package com.example.viacep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/teste")
public class TestController {
    @ResponseBody
    @GetMapping("/teste")
    public String teste (){
        String texto = "cHAMOU CERTO O ENDPOINT";
        return texto;
    }
}

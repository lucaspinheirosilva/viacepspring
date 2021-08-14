package com.example.viacep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TestController {
    @GetMapping("/teste")
    public String teste (){
        String texto = "cHAMOU CERTO O ENDPOINT";
        return texto;
    }
}

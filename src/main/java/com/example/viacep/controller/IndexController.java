package com.example.viacep.controller;
import com.example.viacep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(value = "/cep")
public class IndexController {

    @Autowired
    CepService service;

    @GetMapping("/{cep}")
    public Map<String, Object> index(@PathVariable String cep) {
        return service.cep(cep);
    }
}

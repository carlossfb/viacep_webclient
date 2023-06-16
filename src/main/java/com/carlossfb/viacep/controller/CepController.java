package com.carlossfb.viacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlossfb.viacep.model.Cep;
import com.carlossfb.viacep.service.CepService;

@RestController
@RequestMapping("/api")
public class CepController {
    
    @Autowired
    CepService cepService;

    @GetMapping("/{cep}")
    public Cep getCep(@PathVariable String cep){
        return cepService.getCep(cep);
    }

}

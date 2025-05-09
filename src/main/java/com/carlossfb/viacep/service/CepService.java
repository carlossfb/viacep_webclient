package com.carlossfb.viacep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.carlossfb.viacep.exception.CepNotFoundException;
import com.carlossfb.viacep.model.Cep;

@Service
public class CepService {
    
    @Autowired
    WebClient webClient;

    public Cep getCep(String cep){
        return this.webClient.method(HttpMethod.GET)
            .uri("/{cep}/json", cep)
            .retrieve()
            .onStatus(status -> status.isError(),
                t -> { throw new CepNotFoundException("Erro ao buscar o cep: "+ cep);} 
            )
            .bodyToMono(Cep.class)
            .block();        
    }
}

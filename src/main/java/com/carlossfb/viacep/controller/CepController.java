package com.carlossfb.viacep.controller;


import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlossfb.viacep.model.Cep;
import com.carlossfb.viacep.service.CepService;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping("/api")
public class CepController {
    
    private final CepService cepService;
    private final MeterRegistry meterRegistry;

    private final DistributionSummary latencies;

    public CepController(CepService cepService, MeterRegistry meterRegistry) {
        this.cepService = cepService;
        this.meterRegistry = meterRegistry;
        
        // Configura o DistributionSummary apenas uma vez
        this.latencies = DistributionSummary.builder("api_request_latency_seconds")
            .tags("http_status", "200")  // Tag para o código de status HTTP
            .publishPercentiles(0.5, 0.95, 0.99)  // Percentis (sem SLAs)
            .register(meterRegistry);
    }
    

    @GetMapping("/{cep}")
    public ResponseEntity<Cep> getCep(@PathVariable String cep){
        long start = System.nanoTime();  // Marca o início da requisição
        Cep response = cepService.getCep(cep);
        
        // Criando o link para referência do endpoint com HATEOAS
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CepController.class)
            .getCep(cep)).withSelfRel());

        // Finalizando a medição de tempo e registrando na métrica de latência
        long end = System.nanoTime();  // Marca o fim da requisição
        double durationSeconds = (end - start) / 1_000_000_000.0;  // Convertendo para segundos

        latencies.record(durationSeconds);  // Registrando a latência
        return ResponseEntity.ok(response);
    }

}

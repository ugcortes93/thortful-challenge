package io.github.gustavo.controller;

import  io.github.gustavo.dto.CodigoPostalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta")
public class CodigoPostalController {

    @GetMapping("{cep}")
    public CodigoPostalDTO consulta(@PathVariable String cep){
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<CodigoPostalDTO> response = restTemplate.getForEntity(
                    String.format("https://viacep.com.br/ws/%s/json", cep),
                    CodigoPostalDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException e){
            throw new RuntimeException("CEP invalido!" + e.getMessage());
        }
    }


}

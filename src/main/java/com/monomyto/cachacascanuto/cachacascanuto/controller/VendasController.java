package com.monomyto.cachacascanuto.cachacascanuto.controller;

import com.monomyto.cachacascanuto.cachacascanuto.services.ClientesService;
import com.monomyto.cachacascanuto.cachacascanuto.services.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.monomyto.cachacascanuto.cachacascanuto.model.enums.Respostas.RESPOSTANOK;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    private VendasService vendasService;

    @Autowired
    public VendasController (VendasService vendasService){
        this.vendasService = vendasService;
    }

    @GetMapping(value = "/consultapornome/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultarNomeCliente(@PathVariable(name = "id") String nome){
        if (vendasService.consultarPorNome(nome) == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPOSTANOK);
        } else {
            return ResponseEntity.ok((vendasService.consultarPorNome(nome)));
        }
    }


}

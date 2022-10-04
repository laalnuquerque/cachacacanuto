package com.monomyto.cachacascanuto.cachacascanuto.controller;

import com.monomyto.cachacascanuto.cachacascanuto.model.dto.ClientesDto;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.ClientesEntity;
import com.monomyto.cachacascanuto.cachacascanuto.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.monomyto.cachacascanuto.cachacascanuto.model.enums.Respostas.*;

@RestController
@RequestMapping("/cliente")
public class ClientesController {

    private ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService){
        this.clientesService = clientesService;
    }


    @GetMapping(value = "/consultapornome/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultarNome(@PathVariable(name = "id") String nome){
        if (clientesService.consultarNome(nome) == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPOSTANOK);
        } else {
            return ResponseEntity.ok((clientesService.consultarNome(nome)));
        }
    }

    @RequestMapping(value = "/cliente/consultadatanascimento", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity consultarData(@RequestParam("datainicial") String dataInicial,@RequestParam("datafinal")  String dataFinal){
        if (clientesService.consultarData(dataInicial, dataFinal) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPOSTANOK);
        } else {
//            return ResponseEntity.ok((clientesService.consultarData(dataInicial, dataFinal)));
            return ResponseEntity.ok(clientesService.consultarData(dataInicial, dataFinal));
        }
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultarId(@PathVariable(name = "id") String id){
        if (clientesService.consultarId(id) == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPOSTANOK);
        } else {
            return ResponseEntity.ok((clientesService.consultarId(id)));
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ENCONTRADO);
        }
    }

}

package com.monomyto.cachacascanuto.cachacascanuto.controller;

import com.monomyto.cachacascanuto.cachacascanuto.services.CatalogoService;
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
@RequestMapping("/catalogo")
public class CatalogoController {

    private CatalogoService catalogoService;

    @Autowired
    public CatalogoController(CatalogoService catalogoService){
        this.catalogoService = catalogoService;
    }

    @GetMapping(value = "produtonome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultarProdutoPorNome(@PathVariable(name = "id") String nome){
        if (catalogoService.consultarNome(nome) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPOSTANOK);
        } else {
            return ResponseEntity.ok((catalogoService.consultarNome(nome)));
        }
    }

    @GetMapping(value = "produtoid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultarProdutoPorId(@PathVariable(name = "id") String id){
        if (catalogoService.consultarId(id) == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPOSTANOK);
        } else {
            return ResponseEntity.ok((catalogoService.consultarId(id)));
        }
    }

    @GetMapping(value = "teoralcoolico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultarProdutoPorTeorAlcoolicp(@PathVariable(name = "id") int teorAlcoolicoMinimo, int teorAlcoolicoMaximo){
        if (catalogoService.consultarTeorAlcoolico(teorAlcoolicoMinimo, teorAlcoolicoMaximo) == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPOSTANOK);
        } else {
            return ResponseEntity.ok((catalogoService.consultarTeorAlcoolico(teorAlcoolicoMinimo, teorAlcoolicoMaximo)));
        }
    }
}

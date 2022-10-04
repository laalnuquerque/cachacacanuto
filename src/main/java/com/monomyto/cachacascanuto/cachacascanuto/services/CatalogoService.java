package com.monomyto.cachacascanuto.cachacascanuto.services;

import com.monomyto.cachacascanuto.cachacascanuto.model.dto.CatalogoDto;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.CatalogoEntity;
import com.monomyto.cachacascanuto.cachacascanuto.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class CatalogoService {

    CatalogoRepository catalogoRepository;

    @Autowired
    public CatalogoService (CatalogoRepository catalogoRepository){
        this.catalogoRepository = catalogoRepository;
    }

    public List<CatalogoEntity> consultarNome(String nome){
        List<CatalogoEntity> produtoPorNome = catalogoRepository.findByNomeContainingIgnoreCase(nome);
        if(produtoPorNome.isEmpty()){
            return null;
        } else {
            return produtoPorNome;
        }
    }

    public List<CatalogoEntity> consultarId(String id){
        List<CatalogoEntity> produtoPorId = catalogoRepository.findById(id);
        if(produtoPorId.isEmpty()){
            return null;
        } else {
            return produtoPorId;
        }
    }

    public List<CatalogoEntity> consultarTeorAlcoolico(int teorAlcoolicoMinimo, int tearAlcoolicoMaximo){
        List<CatalogoEntity> teorAlcoolico = catalogoRepository.findByTeorAlcoolicoBetween(teorAlcoolicoMinimo, tearAlcoolicoMaximo);
        if(teorAlcoolico.isEmpty()){
            return null;
        } else {
            return teorAlcoolico;
        }
    }


//• Adicionar busca textual por nome
//• Adicionar filtro com range de teor alcoólico (mínimo, máximo)
//• Retornar dados de um produto específico por ID
}

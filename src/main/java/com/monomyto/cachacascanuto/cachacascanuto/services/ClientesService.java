package com.monomyto.cachacascanuto.cachacascanuto.services;

import com.monomyto.cachacascanuto.cachacascanuto.model.dto.ClientesDto;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.ClientesEntity;
import com.monomyto.cachacascanuto.cachacascanuto.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ClientesService {
    ClientesRepository clientesRepository;

    @Autowired
    public ClientesService (ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }


    public ClientesEntity consultarNomeCompleto(String nome){
        ClientesEntity clientesNomeCompleto = clientesRepository.findByNome(nome);
        if(clientesNomeCompleto == null) {
            return null;
        } else {
            return clientesNomeCompleto;
        }
    }

    public List<ClientesEntity> consultarNome(String nome){
        List<ClientesEntity> clientes = clientesRepository.findByNomeContainingIgnoreCase(nome);
        if(clientes.isEmpty()) {
            return null;
        } else {
            return clientes;
        }
    }

    public List<ClientesEntity> consultarData(String dataInicial, String dataFinal){
        List<ClientesEntity> clientePorData = clientesRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
        if(clientePorData.isEmpty()){
            return null;
        } else {
            return clientePorData;
        }
    }

    public List<ClientesEntity> consultarId(String id){
        List<ClientesEntity> clientes = clientesRepository.findById(id);
        if(clientes.isEmpty()){
            return null;
        } else {
            return clientes;
        }
    }


//    Adicionar busca textual por nome
//    Adicionar filtro por data de nascimento, podendo filtrar em um range de datas (data inicial e final)
//    Retornar dados de um cliente específico por ID
}

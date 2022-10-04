package com.monomyto.cachacascanuto.cachacascanuto.services;

import com.monomyto.cachacascanuto.cachacascanuto.model.dto.ClientesDto;
import com.monomyto.cachacascanuto.cachacascanuto.model.dto.ItensDto;
import com.monomyto.cachacascanuto.cachacascanuto.model.dto.VendasDto;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.CatalogoEntity;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.ClientesEntity;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.ItensEntity;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.VendasEntity;
import com.monomyto.cachacascanuto.cachacascanuto.repository.CatalogoRepository;
import com.monomyto.cachacascanuto.cachacascanuto.repository.ClientesRepository;
import com.monomyto.cachacascanuto.cachacascanuto.repository.VendasRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendasService {

    VendasRepository vendasRepository;
    ClientesRepository clientesRepository;
    CatalogoRepository catalogoRepository;

    private VendasService(VendasRepository vendasRepository, ClientesRepository  clientesRepository, CatalogoRepository catalogoRepository){
        this.vendasRepository = vendasRepository;
        this.clientesRepository = clientesRepository;
        this.catalogoRepository = catalogoRepository;
    }

    public List<VendasEntity> consultarPorNome(String nome){
        String nomeIdCliente = null;
        ClientesEntity idCliente = clientesRepository.findByNome(nome);
        nomeIdCliente = idCliente.getId();

        List<VendasEntity> consultaVendaCliente = vendasRepository.findByIdCliente(nomeIdCliente);
        if(consultaVendaCliente.isEmpty()){
            return null;
        } else {
            return consultaVendaCliente;
        }

    }

    public List<VendasEntity> consultarPorNomeProduto(String nome){
        String nomeIdProduto = null;
        CatalogoEntity idProduto = catalogoRepository.findByNome(nome);
        nomeIdProduto = idProduto.getId();

        List<VendasEntity> consultaVendaProduto = vendasRepository.findByIdCliente(nomeIdProduto);
        if(consultaVendaProduto.isEmpty()){
            return null;
        } else {
            return consultaVendaProduto;
        }

    }

    public List<VendasEntity> consultarData(String dataInicial, String dataFinal){
        List<VendasEntity> vendasPorData = vendasRepository.findByDataBetween(dataInicial, dataFinal);
        if(vendasPorData.isEmpty()){
            return null;
        } else {
            return vendasPorData;
        }
    }

}

package com.monomyto.cachacascanuto.cachacascanuto.services;

import com.monomyto.cachacascanuto.cachacascanuto.model.entities.CatalogoEntity;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.ClientesEntity;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.VendasEntity;
import com.monomyto.cachacascanuto.cachacascanuto.repository.CatalogoRepository;
import com.monomyto.cachacascanuto.cachacascanuto.repository.ClientesRepository;
import com.monomyto.cachacascanuto.cachacascanuto.repository.VendasRepository;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

import static com.monomyto.cachacascanuto.cachacascanuto.model.enums.Respostas.RESPOSTANOK;

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

    public List<List<VendasEntity>> consultarPorNome(String nome) {
        List<ClientesEntity> listIidCliente = clientesRepository.findArrayByNomeContainingIgnoreCase(nome);
        List<List<VendasEntity>> vendasEntity = new ArrayList<>();

        for (ClientesEntity retornoIdCliente : listIidCliente) {
            String nomeIdCliente = retornoIdCliente.getId();

            List<VendasEntity> listaConsultaVendaCliente = vendasRepository.findListaByIdCliente(nomeIdCliente);
            if (!listaConsultaVendaCliente.isEmpty()) {
                vendasEntity.add(listaConsultaVendaCliente);
            }
        }
        return vendasEntity;
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

    public List<VendasEntity> consultarData(String dataInicial){
        List<VendasEntity> vendasPorData = vendasRepository.findByDataContainingIgnoreCase(dataInicial);
        if(vendasPorData.isEmpty()){
            return null;
        }
        return vendasPorData;
    }

    public List<VendasEntity> consultarDataPorRange(String dataInicial, String dataFinal){
        List<VendasEntity> vendasPorData = vendasRepository.findByDataBetween(dataInicial, dataFinal);
        if(vendasPorData.isEmpty()){
            return null;
        } else {
            return vendasPorData;
        }
    }


//  Adicionar filtro por range de datas
//• Adicionar busca textual por nomes de clientes
//• Adicionar busca textual por nomes de produtos
//• Adicionar opções de paginação (número da página e número de itens por página)

//    • Para cada produto, retornar o total de vendas desse produto e a quantidade total vendida
//• Opções de ordenação: Valor total vendido, Quantidade total vendida, crescente ou decrescente

//    • Para cada cliente, retornar o total das vendas para esse cliente
//    Para cada cliente, retornar os produtos que esse cliente mais comprou, podendo especificar uma
//    quantidade máxima de itens

//    Ex: se eu especificar 1, deverá retornar apenas o item que o cliente mais comprou. Isso
//    não altera a estatística de total de vendas, que ainda deve ser feito sob todas as vendas
//do período.
//•
//    Retornar também a quantidade que ele comprou daquele produto, e o valor total das
//    vendas.
//•
//    Permitir filtrar por range de datas (para considerar apenas vendas em um determinado período).
//    Isso afeta a estatística de totais de vendas.
}

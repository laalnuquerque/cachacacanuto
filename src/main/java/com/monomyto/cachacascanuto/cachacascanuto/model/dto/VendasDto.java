package com.monomyto.cachacascanuto.cachacascanuto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendasDto {

    private String id;
    private String idCliente;
    private Date data;
    private List<ItensDto> itens;

}

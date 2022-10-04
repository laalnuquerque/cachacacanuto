package com.monomyto.cachacascanuto.cachacascanuto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensDto {

    private String id;
    private float precoUnitario;
    private int quantidade;

}

package com.monomyto.cachacascanuto.cachacascanuto.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDto {

    private String id;
    private String marca;
    private String classificacao;
    private String nome;
    private int teorAlcoolico;
    private String regiao;
    private float precoAtual;

}

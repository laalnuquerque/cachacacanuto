package com.monomyto.cachacascanuto.cachacascanuto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesDto {

    private String id;
    private String nome;
    private String dataNascimento;

}

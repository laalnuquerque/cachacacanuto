package com.monomyto.cachacascanuto.cachacascanuto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_catalogo")
public class CatalogoEntity {

    @Id
    @Column
    private String id;

    @Column
    private String marca;

    @Column
    private String classificacao;

    @Column
    private String nome;

    @Column
    private int teorAlcoolico;

    @Column
    private String regiao;

    @Column
    private float precoAtual;
}

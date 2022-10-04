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
@Table(name = "tb_itens")
public class ItensEntity {

    @Id
    @Column
    private String id;

    @Column
    private float precoUnitario;

    @Column
    private int quantidade;
}

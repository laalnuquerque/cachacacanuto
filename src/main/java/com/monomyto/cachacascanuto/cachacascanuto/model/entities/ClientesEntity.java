package com.monomyto.cachacascanuto.cachacascanuto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_clientes")
public class ClientesEntity implements Serializable {

    @Id
    @Column
    private String id;

    @Column
    private String nome;

    @Column
    private String dataNascimento;

}

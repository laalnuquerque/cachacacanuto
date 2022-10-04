package com.monomyto.cachacascanuto.cachacascanuto.model.entities;

import com.monomyto.cachacascanuto.cachacascanuto.model.dto.ItensDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vendas")
public class VendasEntity {

    @Id
    @Column
    private String id;

    @Column
    private String idCliente;

    @Column
    private Date data;

//    private List<ItensDto> itens;
}

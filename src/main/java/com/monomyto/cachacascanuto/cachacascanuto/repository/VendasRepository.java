package com.monomyto.cachacascanuto.cachacascanuto.repository;

import com.monomyto.cachacascanuto.cachacascanuto.model.entities.VendasEntity;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface VendasRepository extends JpaRepository<VendasEntity, Long> {

    List<VendasEntity> findByIdCliente(String idCliente);
    List<VendasEntity> findListaByIdCliente(String idCliente);
    List<VendasEntity> findByDataBetween(String dataInicial, String dataFinal);
}

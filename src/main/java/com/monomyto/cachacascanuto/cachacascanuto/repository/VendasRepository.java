package com.monomyto.cachacascanuto.cachacascanuto.repository;

import com.monomyto.cachacascanuto.cachacascanuto.model.entities.VendasEntity;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface VendasRepository extends JpaRepository<VendasEntity, Long> {

    List<VendasEntity> findByIdCliente(String idCliente);
    List<VendasEntity> findListaByIdCliente(String idCliente);
    @Query(value = " SELECT * FROM tb_vendas WHERE data BETWEEN ?1 AND ?2", nativeQuery = true)
    List<VendasEntity> findByDataBetween(String dataInicial, String dataFinal);

    @Query(value = " SELECT * FROM tb_vendas WHERE data LIKE ?1%", nativeQuery = true)
    List<VendasEntity> findByDataContainingIgnoreCase(@Param("data")String dataInicial);
}

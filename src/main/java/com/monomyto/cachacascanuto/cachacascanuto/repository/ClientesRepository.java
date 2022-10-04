package com.monomyto.cachacascanuto.cachacascanuto.repository;

import com.monomyto.cachacascanuto.cachacascanuto.model.entities.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> {

    ClientesEntity findByNome(String nome);
    List<ClientesEntity> findByNomeContainingIgnoreCase(@Param("nome") String nome);
    List<ClientesEntity> findById(String id);
    List<ClientesEntity> findByDataNascimentoBetween(String dataInicial, String dataFinal);
}

package com.monomyto.cachacascanuto.cachacascanuto.repository;

import com.monomyto.cachacascanuto.cachacascanuto.model.entities.CatalogoEntity;
import com.monomyto.cachacascanuto.cachacascanuto.model.entities.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRepository extends JpaRepository<CatalogoEntity,Long> {

    CatalogoEntity findByNome(String nome);
    List<CatalogoEntity> findByNomeContainingIgnoreCase(@Param("nome") String nome);
    List<CatalogoEntity> findByTeorAlcoolicoBetween(int teorAlcoolicoMinimo, int teorAlcoolicoMaximo);
    List<CatalogoEntity> findById(String id);
}

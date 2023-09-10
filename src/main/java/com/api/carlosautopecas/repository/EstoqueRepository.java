package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity,Long> {

    Optional<EstoqueEntity> findByReferenciaPeca(String referenciaPeca);

//    Optional<PecaEntity> findByReferenciaPeca(String referenciaPeca);
}

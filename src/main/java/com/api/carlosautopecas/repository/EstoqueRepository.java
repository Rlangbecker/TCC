package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity,Integer> {

    Optional<EstoqueEntity> findByReferenciaPeca(String referenciaPeca);
//    EstoqueEntity findByReferenciaPeca(String referenciaPeca);

}

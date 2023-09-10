package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Integer> {

    //    List<EstoqueEntity> findByReferenciaPeca(String referenciaPeca);
    EstoqueEntity findByReferenciaPeca(String referenciaPeca);

}

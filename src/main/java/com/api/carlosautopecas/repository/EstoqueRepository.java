package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.EstoqueEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {
    List<Optional<EstoqueEntity>> findByReferenciaPecaContainsIgnoreCase(String referenciaPeca);

    Page<EstoqueEntity> findByReferenciaPecaContainsIgnoreCase(String referenciaPeca, Pageable pageable);


}

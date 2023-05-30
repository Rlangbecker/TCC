package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.entity.PecaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PecaRepository extends JpaRepository<PecaEntity,Long> {

    Page<PecaEntity> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);

//    PecaEntity findPecaEntityByEstoqueEntity(EstoqueEntity estoqueEntity);
}

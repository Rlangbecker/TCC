package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity,Integer> {
}

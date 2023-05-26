package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.PecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepository extends JpaRepository<PecaEntity,Integer> {

}

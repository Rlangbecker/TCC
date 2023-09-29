package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.IdentificadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificadorRepository extends JpaRepository<IdentificadorEntity,Integer> {
}

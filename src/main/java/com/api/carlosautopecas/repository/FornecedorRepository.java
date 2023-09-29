package com.api.carlosautopecas.repository;


import com.api.carlosautopecas.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Integer> {
}

package com.api.carlosautopecas.repository;

import com.api.carlosautopecas.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Integer> {

    //    List<EstoqueEntity> findByReferenciaPeca(String referenciaPeca);
    EstoqueEntity findByReferenciaPeca(String referenciaPeca);
=======
import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity,Integer> {

    Optional<EstoqueEntity> findByReferenciaPeca(String referenciaPeca);
//    EstoqueEntity findByReferenciaPeca(String referenciaPeca);
>>>>>>> 118eaf686a6ac91bdc38fd464d96831976a4646d

}

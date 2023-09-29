package com.api.carlosautopecas.login.repository;


import com.api.carlosautopecas.login.entity.LoginEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends MongoRepository<LoginEntity, String> {
//    UserDetails findByLogin(String login);

    Optional<LoginEntity> findByLogin(String login);
}

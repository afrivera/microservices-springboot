package org.afrivera.springcloud.msvc.users.service;


import org.afrivera.springcloud.msvc.users.model.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {


    @Transactional(readOnly = true)
    List<UserEntity> findAll();

    @Transactional(readOnly = true)
    Optional<UserEntity> findById(Long id);
}

package org.afrivera.springcloud.msvc.users.repository;

import org.afrivera.springcloud.msvc.users.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}

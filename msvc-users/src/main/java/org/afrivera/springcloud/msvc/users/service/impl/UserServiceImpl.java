package org.afrivera.springcloud.msvc.users.service.impl;

import org.afrivera.springcloud.msvc.users.model.entity.UserEntity;
import org.afrivera.springcloud.msvc.users.repository.UserRepository;
import org.afrivera.springcloud.msvc.users.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }
}

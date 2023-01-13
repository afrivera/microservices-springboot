package org.afrivera.springcloud.msvc.users.service.impl;

import org.afrivera.springcloud.msvc.users.dto.RequestUserDto;
import org.afrivera.springcloud.msvc.users.dto.ResponseUserDto;
import org.afrivera.springcloud.msvc.users.exception.ResourceNotFoundException;
import org.afrivera.springcloud.msvc.users.mapper.UserMapper;
import org.afrivera.springcloud.msvc.users.model.entity.UserEntity;
import org.afrivera.springcloud.msvc.users.repository.UserRepository;
import org.afrivera.springcloud.msvc.users.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseUserDto> findAll(){
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(user -> userMapper.userEntityToResponseUserDto(user)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseUserDto findById(Long id){
        return userMapper.userEntityToResponseUserDto(findUserById(id));
    }

    @Override
    @Transactional
    public ResponseUserDto save(RequestUserDto user){
        return userMapper.userEntityToResponseUserDto( userRepository.save(userMapper.requestUserDtoToUser(user)));
    }

    @Override
    public boolean destroy(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

    private UserEntity findUserById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new ResourceNotFoundException("User", "id", id);
        }
        return user.get();
    }
}

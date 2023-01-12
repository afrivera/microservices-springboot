package org.afrivera.springcloud.msvc.users.service;


import org.afrivera.springcloud.msvc.users.dto.RequestUserDto;
import org.afrivera.springcloud.msvc.users.dto.ResponseUserDto;

import java.util.List;

public interface UserService {


    List<ResponseUserDto> findAll();

    ResponseUserDto findById(Long id);

    ResponseUserDto save(RequestUserDto user);

    boolean destroy(Long id);
}

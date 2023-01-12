package org.afrivera.springcloud.msvc.users.mapper;

import org.afrivera.springcloud.msvc.users.dto.RequestUserDto;
import org.afrivera.springcloud.msvc.users.dto.ResponseUserDto;
import org.afrivera.springcloud.msvc.users.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper usermapper = Mappers.getMapper(UserMapper.class);

    UserEntity requestUserDtoToUser(RequestUserDto requestUserDto);
    ResponseUserDto userEntityToResponseUserDto(UserEntity user);
}

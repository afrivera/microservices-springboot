package org.afrivera.springcloud.msvc.courses.mapper;

import org.afrivera.springcloud.msvc.courses.dto.CourseRequestDto;
import org.afrivera.springcloud.msvc.courses.dto.CourseResponseDto;
import org.afrivera.springcloud.msvc.courses.model.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper courseMapper = Mappers.getMapper(CourseMapper.class);

    CourseEntity courseRequestDtoToCourse(CourseRequestDto courseRequestDto);
    CourseResponseDto courseEntityToCourseResponseDto(CourseEntity courseEntity);
}

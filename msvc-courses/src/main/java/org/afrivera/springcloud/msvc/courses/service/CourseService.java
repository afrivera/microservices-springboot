package org.afrivera.springcloud.msvc.courses.service;

import org.afrivera.springcloud.msvc.courses.dto.CourseRequestDto;
import org.afrivera.springcloud.msvc.courses.dto.CourseResponseDto;

import java.util.List;

public interface CourseService {
    List<CourseResponseDto> findAll();

    CourseResponseDto findById(Long id);

    CourseResponseDto save(CourseRequestDto courseRequestDto);

    boolean destroy(Long id);
}

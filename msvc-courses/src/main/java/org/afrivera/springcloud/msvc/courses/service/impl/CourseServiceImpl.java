package org.afrivera.springcloud.msvc.courses.service.impl;

import org.afrivera.springcloud.msvc.courses.dto.CourseRequestDto;
import org.afrivera.springcloud.msvc.courses.dto.CourseResponseDto;
import org.afrivera.springcloud.msvc.courses.repository.CourseRepository;
import org.afrivera.springcloud.msvc.courses.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponseDto> findAll(){
        return null;
    }

    @Override
    public CourseResponseDto findById(Long id){
        return null;
    }

    @Override
    @Transactional
    public CourseResponseDto save(CourseRequestDto courseRequestDto){
        return null;
    }

    @Override
    @Transactional
    public boolean destroy(Long id){
        return false;
    }
}

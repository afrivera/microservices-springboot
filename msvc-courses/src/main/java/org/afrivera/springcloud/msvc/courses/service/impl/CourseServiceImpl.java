package org.afrivera.springcloud.msvc.courses.service.impl;

import org.afrivera.springcloud.msvc.courses.dto.CourseRequestDto;
import org.afrivera.springcloud.msvc.courses.dto.CourseResponseDto;
import org.afrivera.springcloud.msvc.courses.mapper.CourseMapper;
import org.afrivera.springcloud.msvc.courses.model.entity.CourseEntity;
import org.afrivera.springcloud.msvc.courses.repository.CourseRepository;
import org.afrivera.springcloud.msvc.courses.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponseDto> findAll(){
        List<CourseEntity> courses = courseRepository.findAll();
        return  courses.stream().map(courseMapper::courseEntityToCourseResponseDto).collect(Collectors.toList());
    }

    @Override
    public CourseResponseDto findById(Long id){
        return courseMapper.courseEntityToCourseResponseDto(findCourseById(id));
    }

    @Override
    @Transactional
    public CourseResponseDto save(CourseRequestDto courseRequestDto){
        return courseMapper.courseEntityToCourseResponseDto(courseRepository.save(courseMapper.courseRequestDtoToCourse(courseRequestDto)));
    }

    @Override
    @Transactional
    public boolean destroy(Long id){
        Optional<CourseEntity> courseDB = courseRepository.findById(id);
        if(courseDB.isPresent()){
            courseRepository.delete(courseDB.get());
            return true;
        }

        return false;

    }

    private CourseEntity findCourseById(Long id){
        Optional<CourseEntity> courseEntity = courseRepository.findById(id);
        if(!courseEntity.isPresent()){
            throw new RuntimeException("course not found");
        }
        return courseEntity.get();
    }
}

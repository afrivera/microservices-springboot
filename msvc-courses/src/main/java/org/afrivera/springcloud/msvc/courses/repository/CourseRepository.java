package org.afrivera.springcloud.msvc.courses.repository;

import org.afrivera.springcloud.msvc.courses.model.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}

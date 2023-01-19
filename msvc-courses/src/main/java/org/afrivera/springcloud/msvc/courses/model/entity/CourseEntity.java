package org.afrivera.springcloud.msvc.courses.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
    private List<CourseUserEntity> courseUsers;


    public CourseEntity() {
        this.courseUsers = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCourseUser(CourseUserEntity courseUserEntity){
        this.courseUsers.add(courseUserEntity);
    }

    public void removeCourseUser(CourseUserEntity courseUserEntity){
        this.courseUsers.remove(courseUserEntity);
    }
}

package org.afrivera.springcloud.msvc.courses.dto;

import javax.validation.constraints.NotBlank;

public class CourseRequestDto {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

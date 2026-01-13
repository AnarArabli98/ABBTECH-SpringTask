package com.anararabli.abbtech.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "course")
public class CourseConfig {
    private String name;
    private List<String> students;
    private List<String> teacher;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public void setTeacher(List<String> teacher) {
        this.teacher = teacher;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

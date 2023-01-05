package com.heaven.learningspringboot.controller;

import com.heaven.learningspringboot.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @GetMapping("/courses")
    public List<Course> retrieveAllCourse() {
        return Arrays.asList(
                new Course(1, "AWS", "heavenlight"),
                new Course(2, "DevOps", "heavenlight")
        );
    }
}

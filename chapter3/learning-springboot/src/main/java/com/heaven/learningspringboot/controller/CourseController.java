package com.heaven.learningspringboot.controller;

import com.heaven.learningspringboot.entity.Course;
import com.heaven.learningspringboot.repositoyr.CourseRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    private final CourseRepo repo;

    public CourseController(CourseRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> retrieveAllCourse() {
        return new ResponseEntity<>(repo.getAll(), HttpStatus.OK);
    }
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer id){
        return new ResponseEntity<>(repo.findOne(id),HttpStatus.OK);
    }
}

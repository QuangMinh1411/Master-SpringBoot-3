package com.heaven.learningspringboot.repositoyr;

import com.heaven.learningspringboot.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();
    static {
        courses.add(new Course(1, "AWS", "heavenlight"));
        courses.add(new Course(2, "DevOps", "heavenlight"));
    }

    public List<Course> getAll(){
        return courses;
    }
    public Course findOne(Integer id){
        Course course = courses.stream().filter(course1 ->course1.getId()==id).findFirst().orElse(null);
        return course;
    }
}

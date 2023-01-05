package com.heaven.jpademo.course.springjpa;

import com.heaven.jpademo.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseSpringJpaRepository extends JpaRepository<Course,Long> {
    List<Course> findByAuthor(String author);
}

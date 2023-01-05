package com.heaven.jpademo.course;

import com.heaven.jpademo.course.jdbc.CourseJdbcRepository;
import com.heaven.jpademo.course.jpa.CourseJpaRepository;
import com.heaven.jpademo.course.springjpa.CourseSpringJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseCommandLineRunner implements CommandLineRunner {
    private final CourseJdbcRepository repo;
    private final CourseJpaRepository jpaRepo;
    private final CourseSpringJpaRepository jpa;
    @Override
    public void run(String... args) throws Exception {
//        repo.insert(new Course(1,"Learn AWS","heaven"));
//        repo.insert(new Course(2,"Learn Java","John Doe"));
//        repo.insert(new Course(3,"Learn Azure","Microsoft"));
//        repo.deleteById(2L);
//        System.out.println(repo.findById(1L));

//        jpaRepo.insert(new Course(1,"Learn AWS","heaven"));
//        jpaRepo.insert(new Course(2,"Learn Java","John Doe"));
//        jpaRepo.insert(new Course(3,"Learn Azure","Microsoft"));
//        jpaRepo.deleteById(2L);
//        System.out.println(jpaRepo.findById(1L));

        jpa.save(new Course(1,"Learn AWS","heaven"));

        jpa.save(new Course(2,"Learn Java","John Doe"));
        jpa.save(new Course(3,"Learn Azure","Microsoft"));
        jpa.deleteById(2L);
        System.out.println(jpa.findById(1L).get());
        jpa.findAll().forEach(System.out::println);
        System.out.println(jpa.count());
        jpa.findByAuthor("heaven").forEach(System.out::println);

    }
}

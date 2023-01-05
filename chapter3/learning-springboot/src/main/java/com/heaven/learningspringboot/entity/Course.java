package com.heaven.learningspringboot.entity;

import jdk.jfr.DataAmount;

public class Course {
    private Integer id;
    private String name;
    private String author;

    public Course(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.author = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String desc) {
        this.author = desc;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

package com.example.assignment1;

import java.util.List;

import java.util.ArrayList;

public class ClassLevel {

    List<Course> course;
    int level;

    public ClassLevel(int level) {
        this.level = level;
        this.course = new ArrayList<>();
    }

    public void addCourse(Course course){
        this.course.add(course);
    }
}


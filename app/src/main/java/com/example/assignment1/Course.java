package com.example.assignment1;

public class Course {
    String name;
    String subject;

    public Course(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return name;
    }
}

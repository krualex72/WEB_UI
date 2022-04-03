package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface IStudent {
    String getName();
    List<Course> getAllCourses();
}

class Student implements IStudent {
    private String name;
    private List<Course> courses;

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}

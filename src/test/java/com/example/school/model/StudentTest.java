package com.example.school.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testGettersAndSetters() {
        Student s = new Student();
        s.setFirstName("Alice");
        s.setLastName("Smith");
        s.setGrade("10");

        assertEquals("Alice", s.getFirstName());
        assertEquals("Smith", s.getLastName());
        assertEquals("10", s.getGrade());
    }

    @Test
    public void testCoursesAssignment() {
        Student s = new Student();
        Course c = new Course();
        c.setClassName("Biology");

        Set<Course> courses = new HashSet<>();
        courses.add(c);

        s.setCourses(courses);

        assertNotNull(s.getCourses());
        assertTrue(s.getCourses().contains(c));
    }
}


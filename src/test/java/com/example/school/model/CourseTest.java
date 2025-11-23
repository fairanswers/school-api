package com.example.school.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    public void testToStringNotNull() {
        Course c = new Course();
        assertNotNull(c.toString());
    }

    @Test
    public void testCourseInSet() {
        Course c = new Course();
        Set<Course> set = new HashSet<>();
        set.add(c);
        assertTrue(set.contains(c));
    }
}


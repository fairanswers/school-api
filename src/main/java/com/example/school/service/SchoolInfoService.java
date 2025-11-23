package com.example.school.service;

import com.example.school.model.Course;
import com.example.school.model.Student;
import com.example.school.model.Teacher;
import com.example.school.repository.CourseRepository;
import com.example.school.repository.StudentRepository;
import com.example.school.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolInfoService {
    private StudentRepository studentRepo = null;
    private CourseRepository courseRepo = null;
    private TeacherRepository teacherRepo = null;

    public SchoolInfoService(StudentRepository studentRepo, CourseRepository courseRepo, TeacherRepository teacherRepo){
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.teacherRepo = teacherRepo;
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }
}

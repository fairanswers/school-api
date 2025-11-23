package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.model.Course;
import com.example.school.repository.StudentRepository;
import com.example.school.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentController(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @GetMapping
    public List<Student> all() { return studentRepo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return studentRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student create(@RequestBody Student s) { return studentRepo.save(s); }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student s) {
        return studentRepo.findById(id).map(existing -> {
            existing.setFirstName(s.getFirstName());
            existing.setLastName(s.getLastName());
            existing.setGrade(s.getGrade());
            // optionally update courses if provided
            if (s.getCourses() != null && !s.getCourses().isEmpty()) {
                Set<Course> resolved = s.getCourses();
                existing.setCourses(resolved);
            }
            return ResponseEntity.ok(studentRepo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!studentRepo.existsById(id)) return ResponseEntity.notFound().build();
        studentRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

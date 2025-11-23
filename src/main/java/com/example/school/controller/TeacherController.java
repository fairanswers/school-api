package com.example.school.controller;

import com.example.school.model.Teacher;
import com.example.school.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherRepository repo;
    public TeacherController(TeacherRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Teacher> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> get(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Teacher create(@RequestBody Teacher t) { return repo.save(t); }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher t) {
        return repo.findById(id).map(existing -> {
            existing.setFirstName(t.getFirstName());
            existing.setLastName(t.getLastName());
            existing.setDepartment(t.getDepartment());
            existing.setYearsExperience(t.getYearsExperience());
            return ResponseEntity.ok(repo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

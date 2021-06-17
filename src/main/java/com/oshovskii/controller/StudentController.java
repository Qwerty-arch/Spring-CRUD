package com.oshovskii.controller;

import com.oshovskii.entity.Student;
import com.oshovskii.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> findAllProducts() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveOrUpdateStudents(@RequestBody Student student) {
        student.setId(null);
        return studentService.saveOrUpdateStudent(student);
    }

    @PutMapping
    public Student updateStudents(@RequestBody Student student) {
        return studentService.saveOrUpdateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudents(@PathVariable Long id) {
        studentService.deleteById(id);
    }

}

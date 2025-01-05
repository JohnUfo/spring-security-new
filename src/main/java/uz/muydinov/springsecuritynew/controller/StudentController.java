package uz.muydinov.springsecuritynew.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.muydinov.springsecuritynew.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private final List<Student> students = new ArrayList<>(
            List.of(new Student(1, "Student 1", 5),
                    new Student(2, "Student 2", 4),
                    new Student(3, "Student 3", 3),
                    new Student(4, "Student 4", 2),
                    new Student(5, "Student 5", 1)
            ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");


    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
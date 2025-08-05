package com.example.careercenterV2.controllers;


import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.models.requests.add.ProfileStudentRequest;
import com.example.careercenterV2.models.responses.StudentResponse;
import com.example.careercenterV2.models.responses.SuccessResponse;
import com.example.careercenterV2.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private MessageSource messageSource;

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponse>> get() {
        List<StudentResponse> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> get(@PathVariable UUID id) {
        StudentResponse studentResponse = studentService.getStudentById(id);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<StudentResponse> update(@RequestBody ProfileStudentRequest request) {
        StudentResponse studentResponse = studentService.editProfileStudent(request);
        //String successMessage = messageSource.getMessage("student.controller.updateSuccess", null, LocaleContextHolder.getLocale());
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@RequestBody UUID id) {
        studentService.deleteStudentById(id);
        String successMessage = messageSource.getMessage("student.controller.deleteSuccess", null, LocaleContextHolder.getLocale());
        SuccessResponse successResponse = SuccessResponse.builder()
                .message(successMessage).build() ;
        return new ResponseEntity<>(successResponse, HttpStatus.OK);

    }





}

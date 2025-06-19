package com.example.careercenterV2.services;

import com.example.careercenterV2.models.requests.add.ProfileStudentRequest;
import com.example.careercenterV2.models.responses.StudentResponse;

import java.util.List;
import java.util.UUID;

public interface StudentService {



    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(UUID id);

    StudentResponse editProfileStudent(ProfileStudentRequest profile);

    void deleteStudentById(UUID id);







}

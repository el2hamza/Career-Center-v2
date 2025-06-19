package com.example.careercenterV2.services.impl;


import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.mappers.StudentMapper;
import com.example.careercenterV2.models.responses.StudentResponse;
import com.example.careercenterV2.models.requests.add.ProfileStudentRequest;
import com.example.careercenterV2.exceptions.ResourceNotFound;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Value("${student.upload-dir}")
    private String baseUploadDir;

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudentById(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Student not found with id: " + id));
        return studentMapper.entityToResponse(student);
    }

    @Override
    public StudentResponse editProfileStudent(ProfileStudentRequest profile) {
        Student student = studentRepository.findById(profile.getId())
                .orElseThrow(() -> new ResourceNotFound("Student not found with id: " + profile.getId()));

        // Upload CV and photo files if provided
        String uploadDir = baseUploadDir + "/" + student.getId();
        createDirectoryIfNotExist(uploadDir);

        if (profile.getCv() != null && !profile.getCv().isEmpty()) {
            String cvPath = saveFile(uploadDir, "cv.pdf", profile.getCv());
            student.setCv(cvPath);
        }

        if (profile.getPhoto() != null && !profile.getPhoto().isEmpty()) {
            String photoPath = saveFile(uploadDir, "photo.jpg", profile.getPhoto());
            student.setPhoto(photoPath);
        }

        // Update other fields using the mapper
        studentMapper.updateProfileFromRequest(profile, student);
        studentRepository.save(student);

        return studentMapper.entityToResponse(student);
    }

    @Override
    public void deleteStudentById(UUID id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFound("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    private void createDirectoryIfNotExist(String dirPath) {
        Path path = Paths.get(dirPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create directory: " + dirPath, e);
            }
        }
    }

    private String saveFile(String dir, String filename, String fileContentBase64) {
        try {
            byte[] fileData = java.util.Base64.getDecoder().decode(fileContentBase64);
            Path filePath = Paths.get(dir, filename);
            Files.write(filePath, fileData);
            return filePath.toString(); // store the local path in DB
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file: " + filename, e);
        }
    }




}

package com.example.careercenterV2.services.impl;


import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.mappers.StudentMapper;
import com.example.careercenterV2.models.responses.StudentResponse;
import com.example.careercenterV2.models.requests.add.ProfileStudentRequest;
import com.example.careercenterV2.exceptions.ResourceNotFound;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.StudentService;
import com.example.careercenterV2.utils.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final MessageSource messageSource;
    private final FileStorageService fileStorageService;

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
                .orElseThrow(() -> new ResourceNotFound(messageSource.getMessage("Student.not.found",null, Locale.getDefault())));
        return studentMapper.entityToResponse(student);
    }

    @Override
    public StudentResponse editProfileStudent(ProfileStudentRequest profile) {
        Student student = studentRepository.findById(profile.getId())
                .orElseThrow(() -> new ResourceNotFound(messageSource.getMessage("Student.not.found",null, Locale.getDefault())));

        // Upload CV and photo files if provided
        String uploadDir = baseUploadDir + "/" + student.getId();
        fileStorageService.createDirectoryIfNotExist(uploadDir);

        if (profile.getCv() != null && !profile.getCv().isEmpty()) {
            String cvPath = fileStorageService.saveFile(uploadDir, "cv.pdf", profile.getCv());
            student.setCv(cvPath);
        }

        if (profile.getPhoto() != null && !profile.getPhoto().isEmpty()) {
            String photoPath = fileStorageService.saveFile(uploadDir, "photo.jpg", profile.getPhoto());
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
            throw new ResourceNotFound(messageSource.getMessage("Student.not.found",null, Locale.getDefault()));
        }
        studentRepository.deleteById(id);
    }






}

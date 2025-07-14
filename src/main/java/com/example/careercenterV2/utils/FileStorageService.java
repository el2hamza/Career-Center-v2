package com.example.careercenterV2.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class FileStorageService {

    public void createDirectoryIfNotExist(String dirPath) {
        Path path = Paths.get(dirPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create directory: " + dirPath, e);
            }
        }
    }

    public String saveFile(String dir, String filename, String fileContentBase64) {
        try {
            byte[] fileData = Base64.getDecoder().decode(fileContentBase64);
            Path filePath = Paths.get(dir, filename);
            Files.write(filePath, fileData);
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file: " + filename, e);
        }
    }
}

package br.com.lfmelo.java.controllers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Value("${upload.directory}")
    private String uploadDirectory;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }
        try {
            // Define o diretório de upload
            File directory = new File(uploadDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Define o caminho do arquivo de upload
            String filename = file.getOriginalFilename();
            String extension = FilenameUtils.getExtension(filename);
            String filepath = uploadDirectory + File.separator + System.currentTimeMillis() + "." + extension;

            // Salva o arquivo de upload no diretório especificado
            file.transferTo(new File(filepath));

            // Retorna uma resposta de sucesso com o caminho do arquivo de upload
            return new ResponseEntity<>("File uploaded successfully: " + filepath, HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>("Error occurred while uploading the file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package br.com.lfmelo.java.controllers;

import br.com.lfmelo.java.models.FileRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class FileController {

    @PostMapping("/create-file")
    public ResponseEntity<Object> createFile(@RequestBody FileRequest fileRequest) {
        File file = new File(fileRequest.getPath(), fileRequest.getFileName());

        try {
            if (file.createNewFile()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(fileRequest.getContent());
                writer.close();
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("File already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ops");
        }
    }

    @PostMapping("/read-file")
    public ResponseEntity<Object> readFile(@RequestBody FileRequest fileRequest) {
        File file = new File(fileRequest.getPath(), fileRequest.getFileName());

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            reader.close();

            return ResponseEntity.ok(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

package br.com.lfmelo.java.services.impl;

import br.com.lfmelo.java.models.FileRequest;
import br.com.lfmelo.java.services.TextFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.*;

public class TextFileServiceImpl implements TextFileService {

    @Override
    public String readFile(FileRequest fileRequest) {
        File file = new File(fileRequest.getPath(), fileRequest.getFileName());

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            reader.close();

//            return ResponseEntity.ok().build();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            return "";
        }
    }

    @Override
    public String createFile(FileRequest fileRequest) {
        File file = new File(fileRequest.getPath(), fileRequest.getFileName());

        try {
            if (file.createNewFile()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(fileRequest.getContent());
                writer.close();
//                return ResponseEntity.ok().build();
                return "";
            } else {
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("File already exists!");
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ops");
            return "";
        }
    }

}

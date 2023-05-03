package br.com.lfmelo.java.services.impl;

import br.com.lfmelo.java.controllers.exceptions.FileException;
import br.com.lfmelo.java.models.FileRequest;
import br.com.lfmelo.java.services.TextFileService;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
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

            return content.toString();
        } catch (IOException e) {
            throw new FileException("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
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
                return "File created!";
            } else {
                throw new FileException("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileException("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        }
    }

}

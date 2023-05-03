package br.com.lfmelo.java.controllers;

import br.com.lfmelo.java.models.FileRequest;
import br.com.lfmelo.java.services.TextFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/text-file")
public class FileController {

    @Autowired
    private TextFileService service;

    @PostMapping("/create-file")
    public ResponseEntity<Object> createFile(@RequestBody FileRequest fileRequest) {
        return ResponseEntity.ok().body(service.createFile(fileRequest));
    }

    @PostMapping("/read-file")
    public ResponseEntity<Object> readFile(@RequestBody FileRequest fileRequest) {
       return ResponseEntity.ok().body(service.readFile(fileRequest));
    }

}

package br.com.lfmelo.java.controllers;

import br.com.lfmelo.java.models.FileRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/text-file")
public class FileController {

    @PostMapping("/create-file")
    public ResponseEntity<Object> createFile(@RequestBody FileRequest fileRequest) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/read-file")
    public ResponseEntity<Object> readFile(@RequestBody FileRequest fileRequest) {
       return ResponseEntity.ok().build();
    }

}

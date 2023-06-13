package br.com.lfmelo.java.controllers;

import br.com.lfmelo.java.models.FileRequest;
import br.com.lfmelo.java.services.TextFileService;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
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

    @PostMapping("/saveImage")
    public String saveImage(@RequestBody String request) {
        try {
            // Decodificar a string base64 em um array de bytes
            byte[] imageBytes = Base64Utils.decodeFromString(request);

            // Definir o caminho e o nome do arquivo onde a imagem será salva
            String caminhoArquivo = "C:/Users/Luiz/Documents/Dev/java-file-manager/images" + "imagemteste.png";

            // Salvar o array de bytes no arquivo
            try (FileOutputStream imageOutFile = new FileOutputStream(caminhoArquivo)) {
                imageOutFile.write(imageBytes);
                return "A imagem foi salva com sucesso em: " + caminhoArquivo;
            } catch (IOException e) {
                return "Ocorreu um erro ao salvar a imagem: " + e.getMessage();
            }
        } catch (IllegalArgumentException e) {
            return "A string base64 fornecida é inválida.";
        }
    }

}

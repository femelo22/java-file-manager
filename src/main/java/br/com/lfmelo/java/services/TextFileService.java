package br.com.lfmelo.java.services;

import br.com.lfmelo.java.models.FileRequest;

public interface TextFileService {

    String readFile(FileRequest fileRequest);

    String createFile(FileRequest fileRequest);
}

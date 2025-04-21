package com.example.demo.service;


import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocInjectionService {

    @Autowired
    DocumentRepository documentRepository;

    public void saveDocument(Document document) {

        documentRepository.save(document);
    }
}

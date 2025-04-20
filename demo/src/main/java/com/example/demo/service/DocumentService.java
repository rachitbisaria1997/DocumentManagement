package com.example.demo.service;

import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public void saveDocument(Document document) {

        documentRepository.save(document);
    }

    public List<Document> findByAuthor(String author){
        return documentRepository.findDocumentsByAuthor(author);
    }

    public List<Document> findByType(String type){
        return documentRepository.findDocumentsByType(type);
    }

    public List<Document> findByKeyword(String content){
        return documentRepository.findDocumentsByKeyword(content);
    }

    public List<Document> findById(int id){

        return documentRepository.findDocumentsById(id);

    }

}

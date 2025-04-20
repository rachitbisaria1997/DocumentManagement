package com.example.demo.service;

import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public void saveDocument(Document document) {

        documentRepository.save(document);
    }

    public Page<Document> findByAuthor(String author, Pageable pageable){
        return documentRepository.findDocumentsByAuthor(author);
    }

    public Page<Document> findByType(String type, Pageable pageable){
        return documentRepository.findDocumentsByType(type);
    }

    public Page<Document> findByKeyword(String content, Pageable pageable){
        return documentRepository.findDocumentsByKeyword(content);
    }

    public Page<Document> findById(int id){

        return documentRepository.findDocumentsById(id);

    }

    public Page<Document> getSortedDocuments(Pageable pageable) {
        return documentRepository.findAll(pageable);
    }

}

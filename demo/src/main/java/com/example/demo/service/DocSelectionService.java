package com.example.demo.service;

import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocSelectionService {

    @Autowired
    DocumentRepository documentRepository;

    public void saveDocument(Document document) {

        documentRepository.save(document);
    }

    public Page<Document> findByAuthor(String author, Pageable pageable){
        return documentRepository.findDocumentsByAuthor(author, pageable);
    }

    public Page<Document> findByType(String type, Pageable pageable){
        return documentRepository.findDocumentsByType(type, pageable);
    }

    public Page<Document> findByKeyword(String content, Pageable pageable){
        return documentRepository.findDocumentsByKeyword(content, pageable);
    }

    public Page<Document> findById(int id){

        return documentRepository.findDocumentsById(id);

    }

    public Page<Document> getSortedDocuments(Pageable pageable) {
        return documentRepository.findAll(pageable);
    }

}

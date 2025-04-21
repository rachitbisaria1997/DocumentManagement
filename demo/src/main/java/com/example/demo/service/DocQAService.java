package com.example.demo.service;

import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocQAService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> findByQuestion(String question){


        String [] keywords = question.split("\\s+");
        List<Document> documents = new ArrayList<>();

        for(String keyword : keywords){

            documents.add((Document) documentRepository.findDocumentsByTitleSummary(keyword));
        }

        return documents;

    }

}

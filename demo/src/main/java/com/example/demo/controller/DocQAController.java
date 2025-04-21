package com.example.demo.controller;

import com.example.demo.DTO.QuestionRequest;
import com.example.demo.entity.Document;
import com.example.demo.service.DocQAService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DocQAController {

    @Autowired
    private DocQAService docQAService;

    private static Logger logger = (Logger) LoggerFactory.getLogger(DocSelectionController.class);

    @GetMapping("/askQuestion")
    public ResponseEntity<List<Document>> searchByQuestion(@RequestBody QuestionRequest questionRequest){

        List<Document> answers = docQAService.findByQuestion(questionRequest.getQuestion());

        return ResponseEntity.of(java.util.Optional.ofNullable(answers));

    }

}

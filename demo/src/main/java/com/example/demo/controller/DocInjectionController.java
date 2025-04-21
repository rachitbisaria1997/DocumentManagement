package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.service.DocInjectionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;

@Repository
public class DocInjectionController {

    @Autowired
    private DocInjectionService documentInjection;

    private static Logger logger = (Logger) LoggerFactory.getLogger(DocSelectionController.class);


    @PostMapping("/save/document")
    public ResponseEntity<String> saveDocument(@RequestBody Document document){

        try{
            documentInjection.saveDocument(document);
            logger.info("Document is saved successfully");
            return new ResponseEntity<>("Document is saved successfully", HttpStatus.CREATED);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in saving the document ");
        }
    }

}

package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    private static Logger logger = (Logger) LoggerFactory.getLogger(DocumentController.class);


    @PostMapping("/save/document")
    public ResponseEntity<String> saveDocument(@RequestBody Document document){

        try{
            documentService.saveDocument(document);
            logger.info("Document is saved successfully");
            return new ResponseEntity<>("Document is saved successfully", HttpStatus.CREATED);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the document ");
        }

    }

    @GetMapping("/searchDocument")
    public ResponseEntity<List<Document>> searchDocuments(
            @RequestParam(required = false) int id,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

                List<Document> result = null;

                if(author != null){
                    result = documentService.findByAuthor(author);
                }

                if(type != null){
                    result = documentService.findByType(type);
                    
                }

                if(keyword != null){
                    result = documentService.findByKeyword(keyword);
                }

                if(id != -1){
                    result = documentService.findById(id);
                    
                }
             return new ResponseEntity<>(result, HttpStatus.OK);
                
    }

}

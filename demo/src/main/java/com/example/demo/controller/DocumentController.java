package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<Document>> searchDocuments(
            @RequestParam(required = false) int id,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String[] sort
            )
            {

                Sort sorting = Sort.by(Sort.Direction.fromString(sort[1]), sort[0]);
                Pageable pageable = PageRequest.of(page, size, sorting);

                Page<Document> result = null;

                if(author != null){
                    result = documentService.findByAuthor(author, pageable);
                }

                if(type != null){
                    result = documentService.findByType(type, pageable);
                }

                if(keyword != null){
                    result = documentService.findByKeyword(keyword, pageable);
                }

                if(id != -1){
                    result = documentService.findById(id);
                    
                }

                return ResponseEntity.ok(result);

            }

}

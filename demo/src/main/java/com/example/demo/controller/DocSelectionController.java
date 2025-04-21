package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.service.DocSelectionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class DocSelectionController {

    @Autowired
    private DocSelectionService docSelectionService;

    private static Logger logger = (Logger) LoggerFactory.getLogger(DocSelectionController.class);

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
                    result = docSelectionService.findByAuthor(author, pageable);
                }

                if(type != null){
                    result = docSelectionService.findByType(type, pageable);
                }

                if(keyword != null){
                    result = docSelectionService.findByKeyword(keyword, pageable);
                }

                if(id != -1){
                    result = docSelectionService.findById(id);
                    
                }

                return ResponseEntity.ok(result);

            }

}

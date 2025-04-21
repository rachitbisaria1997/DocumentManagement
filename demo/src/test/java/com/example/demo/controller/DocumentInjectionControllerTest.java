package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

public class DocumentInjectionControllerTest {

    @MockBean
    private DocInjectionController docInjectionController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void saveDocumentTest(){

        String documentJson = """
            {   "id" : 1,
                "title": "Master Java",
                "content": "In depth guide in Java",
                "author": "Dave Kishner",
                "summary": "Covers essentials and advanced topics in Java",
                "type": "Technical Book",
                "date": "2024-04-12",
                "price": 500,
                "pages": 350
            }
        """;

        mockMvc.perform(post("/documents/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(documentJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Document is saved successfully"));

    }


}

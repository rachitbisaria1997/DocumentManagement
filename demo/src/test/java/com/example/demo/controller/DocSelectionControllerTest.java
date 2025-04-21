package com.example.demo.controller;

import com.example.demo.entity.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

public class DocSelectionControllerTest {

    @MockBean
    private DocSelectionController docSelectionController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchDocumentsTest(){

        Document doc1 = new Document();
        doc1.setId(1L);
        doc1.setTitle("Java Guide");
        doc1.setAuthor("John");

        Document doc2 = new Document();
        doc1.setId(2L);
        doc1.setTitle("Spring Guide");
        doc1.setAuthor("David");

        List<Document> documents = List.of(doc1, doc2);

         mockMvc.perform(get("/searchDocument"))
                    .andExpect(status().isOk()
                    .param("author", "John"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.content[0].title").value("Java Guide"));

    }

}

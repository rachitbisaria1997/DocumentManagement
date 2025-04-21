package com.example.demo.controller;

import com.example.demo.DTO.QuestionRequest;
import com.example.demo.entity.Document;
import org.aspectj.lang.annotation.Before;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

public class DocQAControllerTest {

    @MockBean
    private DocQAController docQAController;

    @Mock
    QuestionRequest request;

    private List<Document> documents;

    @Before("")
    void setup(){
        request = new QuestionRequest("Java");
    }

    @Test
    void test_document_list(){

        documents = (List<Document>) docQAController.searchByQuestion(request);
        assert.assertTrue(documents.size() > 1, "Documents is not fetched");
    }


}

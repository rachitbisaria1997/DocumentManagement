package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Document {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    private String summary;
    private String type;
    private Date date;
    private int price;
    private int pages;

    public Document(Long id, String title, String content, String author, String summary, String type, Date date, int price, int pages) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.summary = summary;
        this.type = type;
        this.date = date;
        this.price = price;
        this.pages = pages;
    }

}

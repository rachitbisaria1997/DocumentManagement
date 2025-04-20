package com.example.demo.repository;

import com.example.demo.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query("SELECT * from Document where author = :author")
    List<Document> findDocumentsByAuthor(@Param("author") String author);

    @Query("SELECT * from Document where type = :type")
    List<Document> findDocumentsByType(@Param("type") String type);

    @Query("SELECT * from Document where content LIKE '%content%'")
    List<Document> findDocumentsByKeyword(@Param("content") String content);

    @Query("SELECT * FROM Document where id = :id")
    List<Document> findDocumentsById(@Param(("id")) int id);
}

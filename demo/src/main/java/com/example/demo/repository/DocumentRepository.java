package com.example.demo.repository;

import com.example.demo.entity.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    Page<Document> findAll(Pageable pageable);


    @Query("SELECT * from Document where author = :author")
    Page<Document> findDocumentsByAuthor(@Param("author") String author);

    @Query("SELECT * from Document where type = :type")
    Page<Document> findDocumentsByType(@Param("type") String type);

    @Query("SELECT * from Document where content LIKE '%keyword%'")
    Page<Document> findDocumentsByKeyword(@Param("content") String keyword);

    @Query("SELECT * FROM Document where id = :id")
    Page<Document> findDocumentsById(@Param(("id")) int id);

}

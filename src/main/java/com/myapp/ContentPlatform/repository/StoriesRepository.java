package com.myapp.ContentPlatform.repository;

import com.myapp.ContentPlatform.model.post.Stories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoriesRepository extends JpaRepository<Stories,Long> {
    @Query("SELECT p FROM Post p JOIN p.tags t WHERE t.name = :tagName")
    List<Stories> findByTagName(String tagName);
}

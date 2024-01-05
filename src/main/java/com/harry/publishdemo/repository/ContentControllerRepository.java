package com.harry.publishdemo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.harry.publishdemo.model.Content;
import com.harry.publishdemo.model.Status;
import com.harry.publishdemo.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentControllerRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentControllerRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    public void init() {
        contentList.add(new Content(1, "This is my first blog post", "My first blog post", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, ""));
        contentList.add(new Content(2, "This is my 11 blog post", "My 11 blog post", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, ""));
        contentList.add(new Content(3, "This is my 111 blog post", "My 111 blog post", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, ""));
    }

    public void setContentList(List<Content> content) {
        this.contentList.addAll(content);
    }

    public void saveContent(Content content) {
        this.contentList.add(content);
    }
    
    public void deleteContent(Integer id) {
        this.contentList.removeIf(c -> c.id().equals(id));
    }
    
    public Content updateContent(Content content, Integer id) {
        this.contentList.removeIf(c -> c.id().equals(id));
        this.contentList.add(content);
        return content;
    }
}

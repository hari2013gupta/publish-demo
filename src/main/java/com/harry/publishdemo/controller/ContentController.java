package com.harry.publishdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.harry.publishdemo.Message;
import com.harry.publishdemo.model.Content;
import com.harry.publishdemo.repository.ContentControllerRepository;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    final ContentControllerRepository repository;

    public ContentController(ContentControllerRepository contentcControllerRepository) {
        this.repository = contentcControllerRepository;
    }

    /**
     * 
     * @return contentList
     */
    @GetMapping("/message")
    public String message() {
        return Message.getMessage();
    }

    /**
     * 
     * @return contentList
     */
    @GetMapping("/findAll")
    public List<Content> findAll() {
        return repository.findAll();
    }

    /**
     * @param id
     * @return content
     */
    @GetMapping(value = "/findById/{id}")
    public Content findById(@PathVariable("id") Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public void create(@RequestBody Content content) {
        repository.saveContent(content);
    }

    @PutMapping("update/{id}")
    public Content update(@PathVariable Integer id, @RequestBody Content c) {

        return repository.updateContent(c, id);
    }

    @PutMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {

        repository.deleteContent(id);
    }

}

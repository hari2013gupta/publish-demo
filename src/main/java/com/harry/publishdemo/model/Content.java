package com.harry.publishdemo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public record Content(
                @Id Integer id,
                String tiitle,
                String description,
                Status status,
                Type contentType,
                LocalDateTime createdAt,
                LocalDateTime updatedAt, String url) {

}

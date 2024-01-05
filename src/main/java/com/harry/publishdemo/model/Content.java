package com.harry.publishdemo.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String tiitle,
        String desc,
        Status status,
        Type contentType, LocalDateTime createdAt,
        LocalDateTime updatedAt, String url) {

}

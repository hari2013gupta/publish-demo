package com.harry.publishdemo;

import org.springframework.stereotype.Component;

@Component
public class Message {
    public static String getMessage() {
        return "Hello Spring World!";
    }
}

package com.example.mobileproject.data;

public class Alarm {
    private String title;
    private String content;

    public Alarm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}


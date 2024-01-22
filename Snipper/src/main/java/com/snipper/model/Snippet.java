package com.snipper.model;

public class Snippet {
    private int id;
    private String language;
    private String code;

    public Snippet(int id, String language, String code) {
        this.id = id;
        this.language = language;
        this.code = code;
    }

    // Getter methods

    public int getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public String getCode() {
        return code;
    }
}

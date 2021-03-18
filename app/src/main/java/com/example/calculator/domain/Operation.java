package com.example.calculator.domain;

public enum Operation {
    ADD ("+"),
    DIV ("/"),
    MULT ("*"),
    SUB ("-");

    private String title;

    Operation(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

package com.ingemark.dto;

public enum ProductField {
    ID("id"),
    CODE("code"),
    NAME("name");

    private final String name;

    ProductField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

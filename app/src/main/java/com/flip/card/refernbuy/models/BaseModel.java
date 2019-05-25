package com.flip.card.refernbuy.models;

public class BaseModel {

    private String id;
    private String name;

    public BaseModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

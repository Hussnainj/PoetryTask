package com.example.wasim.poetrytask;

/**
 * Created by wasim on 10/8/2016.
 */
public class Poetry {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private  int id;
    private  String title;
    private  String type;
    private  String description;

    @Override
    public String toString() {
        return type;
    }
}

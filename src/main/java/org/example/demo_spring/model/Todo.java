package org.example.demo_spring.model;

import lombok.Data;

@Data
public class Todo {
    private String name;
    private String description;
    private boolean isDone;

    public void setIsDone(boolean b) {
    }
}

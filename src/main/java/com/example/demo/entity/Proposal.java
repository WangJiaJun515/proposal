package com.example.demo.entity;
import lombok.Data;
@Data
public class Proposal {
    private Integer id;
    private String writer;
    private String topic;
    private String content;
    private String comment;

    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }
}


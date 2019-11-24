package com.sharjahegov.nytpopulararticles;

import java.io.Serializable;

public class ArticleData implements Serializable {
    int id;
    String subject;
    String description;
    String image;
    String date;
    public ArticleData(Integer id, String subject, String description,String image,String date) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.image = image;
        this.date = date;
    }
}

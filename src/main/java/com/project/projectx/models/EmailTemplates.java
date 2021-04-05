package com.project.pavani.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailTemplates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String action;
    private String subject;
    private String htmlPath;

    public Integer getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getHtmlPath() {
        return htmlPath;
    }
}

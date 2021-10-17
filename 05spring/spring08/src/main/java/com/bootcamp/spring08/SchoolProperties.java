package com.bootcamp.spring08;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "school")
public class SchoolProperties {

    private int student123Id;

    private String student123Name;

    private int student100Id;

    private String student100Name;

    public int getStudent123Id() {
        return student123Id;
    }

    public void setStudent123Id(int student123Id) {
        this.student123Id = student123Id;
    }

    public String getStudent123Name() {
        return student123Name;
    }

    public void setStudent123Name(String student123Name) {
        this.student123Name = student123Name;
    }

    public int getStudent100Id() {
        return student100Id;
    }

    public void setStudent100Id(int student100Id) {
        this.student100Id = student100Id;
    }

    public String getStudent100Name() {
        return student100Name;
    }

    public void setStudent100Name(String student100Name) {
        this.student100Name = student100Name;
    }
}

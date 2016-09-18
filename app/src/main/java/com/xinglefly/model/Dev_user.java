package com.xinglefly.model;

import java.io.Serializable;

public class Dev_user implements Serializable {

    private Integer id;
    private String name;
    private String avatar;
    private String bio;
    private String company;
    private String title;
    private String foll_skill;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFoll_skill() {
        return foll_skill;
    }

    public void setFoll_skill(String foll_skill) {
        this.foll_skill = foll_skill;
    }

    public Dev_user() {
    }
}
package com.xinglefly.model;

import java.io.Serializable;

public class DeveloperUser implements Serializable{

    /*"user":{
        "id":"230560", "name":"炼金术士", "avatar":
        "http://toutiaoio.qiniudn.com/user/78647f5bc3ec43b3a47ac5c4d402f1a5/thumb", "bio":
        "全栈", "following":false, "company":"保密", "title":"高级开发工程师", "follow_skill":
        "Java，node，iOS"
    }*/

    private Integer id;
    private String name;
    private String avatar;
    private String bio;
    private boolean following;
    private String company;
    private String title;
    private String follow_skill;

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

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
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

    public String getFollow_skill() {
        return follow_skill;
    }

    public void setFollow_skill(String follow_skill) {
        this.follow_skill = follow_skill;
    }
}
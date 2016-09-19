package com.xinglefly.entity;

import java.io.Serializable;

public class Subject implements Serializable {

    /*"subject":{
        "id":136908, "name":"炼金术士", "image":
        "http://toutiaoio.qiniudn.com/subject/7ff301d003464f20a12f9e315b7e1ff8/thumb", "type":
        "person"
    }*/

    private Integer id;
    private String name;
    private String image;
    private String type;


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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
package com.xinglefly.model;

import java.io.Serializable;
import java.util.ArrayList;

public class DeveloperItem implements Serializable{


    /*{"errcode":0, "msg":"ok", "ret":0, "data":[{
        "id":87719, "name":"Dbaplus.cn精选文章", "image":
        "http://toutiaoio.qiniudn.com/subject/3dee6b6fe71449f3b53ecea8d1616eed/thumb", "description":
        "数据连接未来！围绕数据库、大数据、PaaS云，顶级大咖、技术干货，每天精品原创文章推送、每周线上技术分享、每月线下技术沙龙，场场爆满、受众过十万，成为运维圈最专注围绕“数据”的学习交流和专业社群！更多精彩，欢迎关注dbaplus.cn!", "post_count":
        198, "subscriber_count":815, "type":"team", "user":{
            "id":"211315", "name":"Dbaplus.cn精选文章", "avatar":
            "http://toutiaoio.qiniudn.com/user/b9b4cd8f019f4c02bff4fc72528c16e6/thumb", "bio":
            "", "company":null, "title":null, "follow_skill":null
        },"created_at":1458736282, "subscribed":false, "member_count":1, "push_enabled":false
    }*/

    private Integer id;
    private String name;
    private String image;
    private String description;
    private Integer subscriber_count;
    private String type;
    private Long create_at;
    private boolean subscribed;
    private Integer member_count;
    private boolean push_enabled;
    public ArrayList<Dev_user> devUsers;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSubscriber_count() {
        return subscriber_count;
    }

    public void setSubscriber_count(Integer subscriber_count) {
        this.subscriber_count = subscriber_count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Integer getMember_count() {
        return member_count;
    }

    public void setMember_count(Integer member_count) {
        this.member_count = member_count;
    }

    public boolean isPush_enabled() {
        return push_enabled;
    }

    public void setPush_enabled(boolean push_enabled) {
        this.push_enabled = push_enabled;
    }

    public ArrayList<Dev_user> getDevUsers() {
        return devUsers;
    }

    public void setDevUsers(ArrayList<Dev_user> devUsers) {
        this.devUsers = devUsers;
    }

    public DeveloperItem() {

    }
}

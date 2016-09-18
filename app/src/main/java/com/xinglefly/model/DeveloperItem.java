package com.xinglefly.model;

import java.io.Serializable;
import java.util.ArrayList;

public class DeveloperItem implements Serializable{


    /*"article":[{
            "show_origin_content":false, "is_advertorial":false, "id":612861, "title":
            "WebSocket 和 Socket 的区别", "contributor":"炼金术士", "original_site_name":
            "jianshu.com", "is_recommend":false, "original_url":
            "http://toutiao.io/j/kbujf3", "image":null, "thumbnail":"", "is_featured":
            true, "comment_count":5, "like_count":33, "liked":false, "subject":{
                "id":136908, "name":"炼金术士", "image":
                "http://toutiaoio.qiniudn.com/subject/7ff301d003464f20a12f9e315b7e1ff8/thumb", "type":
                "person"
            },"user":{
                "id":"230560", "name":"炼金术士", "avatar":
                "http://toutiaoio.qiniudn.com/user/78647f5bc3ec43b3a47ac5c4d402f1a5/thumb", "bio":
                "全栈", "following":false, "company":"保密", "title":"高级开发工程师", "follow_skill":
                "Java，node，iOS"
            },"author_info":{
                "name":"TheAlchemist", "url":""
            },"created_at":1473739503
        }
    }*/

    private boolean show_origin_content;
    private boolean is_advertorial;
    private Integer id;
    private String title;
    private String contributor;
    private String original_site_name;
    private boolean is_recommend;
    private String original_url;
    private String image;
    private String thumbnail;
    private boolean is_featured;
    private Integer comment_count;
    private Integer like_count;
    private boolean liked;
    private Long created_at;

    private Subject subject;
    private DeveloperUser user;

    public boolean isShow_origin_content() {
        return show_origin_content;
    }

    public void setShow_origin_content(boolean show_origin_content) {
        this.show_origin_content = show_origin_content;
    }

    public boolean is_advertorial() {
        return is_advertorial;
    }

    public void setIs_advertorial(boolean is_advertorial) {
        this.is_advertorial = is_advertorial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getOriginal_site_name() {
        return original_site_name;
    }

    public void setOriginal_site_name(String original_site_name) {
        this.original_site_name = original_site_name;
    }

    public boolean is_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(boolean is_recommend) {
        this.is_recommend = is_recommend;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean is_featured() {
        return is_featured;
    }

    public void setIs_featured(boolean is_featured) {
        this.is_featured = is_featured;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public DeveloperUser getUser() {
        return user;
    }

    public void setUser(DeveloperUser user) {
        this.user = user;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }
}

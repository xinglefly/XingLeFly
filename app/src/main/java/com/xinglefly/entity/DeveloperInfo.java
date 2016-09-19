package com.xinglefly.entity;

import java.util.List;

public class DeveloperInfo {

    /*{
        "errcode":0, "msg":"ok", "ret":0, "data":{
        "date":"2016-09-14", "pre_date":"2016-09-13", "next_date":"", "is_today":true, "share_url":
        "http://toutiao.io", "article":[{
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
    }}*/


    //Data
    private String date;
    private String pre_date;
    private String next_date;
    private boolean is_today;
    private String share_url;
    private List<Article> article;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPre_date() {
        return pre_date;
    }

    public void setPre_date(String pre_date) {
        this.pre_date = pre_date;
    }

    public String getNext_date() {
        return next_date;
    }

    public void setNext_date(String next_date) {
        this.next_date = next_date;
    }

    public boolean is_today() {
        return is_today;
    }

    public void setIs_today(boolean is_today) {
        this.is_today = is_today;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public List<Article> getArticles() {
        return article;
    }

    public void setArticles(List<Article> article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "DeveloperInfo{" +
                "date='" + date + '\'' +
                ", pre_date='" + pre_date + '\'' +
                ", next_date='" + next_date + '\'' +
                ", is_today=" + is_today +
                ", share_url='" + share_url + '\'' +
                ", article=" + article +
                '}';
    }
}
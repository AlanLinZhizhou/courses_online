package com.qingguatang.java5minute.course4.model;

import java.util.Date;

public class Comment {

    private String id;    //评论的id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String icon;  //评论人头像

    private  String nickname;    //昵称

    private  String content;    //评论内容

        private Date commentTime;  //评论时间

    private int likeNum;       //点赞数

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}

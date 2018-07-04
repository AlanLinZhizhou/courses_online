package com.qingguatang.java5minute.course4;

import java.util.ArrayList;
import java.util.List;

import com.qingguatang.java5minute.course4.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CommentControl {

    @RequestMapping(value="/comments")
    public String comments(ModelMap modelMap){

        List<Comment> comments=getComment();
        modelMap.addAttribute("comments",comments);
        return "comments";
    }

    private List<Comment> getComment(){
        //comment data 1
        List<Comment> comments = new ArrayList<>();
        Comment comment =new Comment();
        comment.setIcon("http://p1.music.126.net/xHAQ2seY8igYbjujpSB8Ug==/109951163348615205.jpg?param=50y50");
        comment.setNickname("AriLuv");
        comment.setCommentTime("2015年10月23日");
        comment.setContent("hello！一转眼四年了！终于等到王者的归来~阿呆的全球屠榜又要开始啦！在此献上我的鸡腿！嘻嘻~");
        comment.setLikeNum(84905);
        comments.add(comment);

        //comment data 2
        comment =new Comment();
        comment.setIcon("http://p1.music.126.net/eLZfXg6oY_xqWmd3hzQg-w==/109951163043012263.jpg?param=50y50");
        comment.setNickname("Edawn");
        comment.setCommentTime("2015年12月13日");
        comment.setContent("这hello应该翻译成别来无恙更恰当。");
        comment.setLikeNum(66133);
        comments.add(comment);


        return comments;
    }
}

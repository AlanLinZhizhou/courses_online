package com.qingguatang.java5minute.course5;

import com.qingguatang.java5minute.course4.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class CommentPostControl {

    //哈希表常量的定义
    private static Map<String,List<Comment>> comments =new HashMap<>();

    @RequestMapping(value="/comment/post")
    public String post(@RequestParam(value = "songId") String songId, Comment comment){    //

        Date commentTime =new Date();
        comment.setCommentTime(commentTime);
        comment.setId(UUID.randomUUID().toString());
        comments.computeIfAbsent(songId,k->new ArrayList<>()).add(comment);   //完成评论数据的添加,java8的新语法

        /*List<Comment> res;
        if(comments.containsKey(songId)){
            res=comment.get(SongId);
        }else{
            res =new ArrayList<>();
            comments.put(songId,res);
        }
        res.add(comment);*/

        //对评论进行倒序排序,使其能够显示最新评论
        List<Comment> commentlist =comments.get(songId);
        Collections.sort(commentlist, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
               if(o1.getCommentTime().after(o2.getCommentTime())) {
                   return -1;
               }
               return  1;
            }
            });


         return "redirect:/comments";
    }

    public List<Comment> getComments(String songId){
        return comments.get(songId);
    }
}

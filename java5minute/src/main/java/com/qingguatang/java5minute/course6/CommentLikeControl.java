package com.qingguatang.java5minute.course6;

import com.qingguatang.java5minute.course4.model.Comment;
import com.qingguatang.java5minute.course5.CommentPostControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentLikeControl {

    @Autowired
    private CommentPostControl commentPostControl;


    @RequestMapping(value="/comment/like")    //may be bug
    @ResponseBody
    public Comment like(@RequestParam(value="songId") String songId,@RequestParam(value="commentId")String commentId){

        List<Comment> commentList =commentPostControl.getComments(songId);   //根据songId得到所有的评论数据
        Comment result=null;     //用于返回
        for(Comment comment:commentList){
            if(!comment.getId().equals(commentId)){
                continue;
            }
            comment.setLikeNum(comment.getLikeNum()+1);
            result=comment;
        }
        return result;
    }

}

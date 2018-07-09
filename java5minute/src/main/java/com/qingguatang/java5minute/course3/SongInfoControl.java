package com.qingguatang.java5minute.course3;

import com.qingguatang.java5minute.course3.model.SongInfo;
import com.qingguatang.java5minute.course4.model.Comment;
import com.qingguatang.java5minute.course5.CommentPostControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SongInfoControl {

    private  static Map<String,SongInfo> songInfoMap =new HashMap<>();

    @Autowired
    private CommentPostControl commentPostControl;

    @RequestMapping(value="/songinfo")
    public String index(String songId,ModelMap modelMap){   //ModelMap用于传递歌曲数据

      if(songId == null){
          songId="35847388";
      }
        SongInfo songinfo =songInfoMap.get(songId);
        modelMap.addAttribute("song",songinfo);
        List<Comment> comments=commentPostControl.getComments(songId);
        modelMap.addAttribute("comments",comments);
        return "index";
    }

    @RequestMapping(value="/songinfo/get")
    @ResponseBody
    public SongInfo get(String songId){
        SongInfo songInfo=songInfoMap.get(songId);
        return songInfo;
    }

    @PostConstruct
    public void init(){

        //hello
        SongInfo songinfo=new SongInfo();
        songinfo.setId("35847388");
        songinfo.setName("Hello");
        songinfo.setSinger("Adele");
        songinfo.setAlbumName("Hello");
        songinfo.setCommentCount(10);
        songinfo.setAlbumImg("http://p1.music.126.net/PrO7oPvnjvH4xdujdGbf2w==/1407374890649284.jpg?param=130y130");
        songinfo.setLyrics("Hello, it's me<br/>你好吗 是我<br/>I was wondering if after all these years you'd like to meet<br/>我犹豫着要不要给你来电 不确定多年后你是否还愿相见<br/>");
        songInfoMap.put("35847388",songinfo);

        //
        songinfo=new SongInfo();
        songinfo.setId("16435049");
        songinfo.setName("在阳光下失落的影子");
        songinfo.setSinger("盯鞋人");
        songinfo.setAlbumName("极简主义");
        songinfo.setCommentCount(5);
        songinfo.setAlbumImg("http://p4.music.126.net/PsSBjLptpmpVZV5PpwwzRw==/18870918068123233.jpg?param=200y200");
        songinfo.setLyrics("绿海炙烧阴暗<br/>惨遭屠戮<br/>月迹划痕<br/>蓝血铺满<br/><br/><br/>无知与懦弱<br/>一点一滴 暴露无疑<br/>");
        songInfoMap.put("16435049",songinfo);
    }
}

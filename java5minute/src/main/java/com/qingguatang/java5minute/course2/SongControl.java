package com.qingguatang.java5minute.course2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SongControl {

    @RequestMapping(value="/song")   //用于指定url,当url为localhost时，/song就可请求该方法
    public String getSong(@RequestParam(name="id",required = false) String songId){   //@RequestParam用于获取网页传递过来的参数
        //判断这个songId
        if(songId == null){
            songId="1";
        }

        if(songId.equals("1")){
            return "course2/1.html";
        }else{
            return "course2/other.html";
        }

    }
}

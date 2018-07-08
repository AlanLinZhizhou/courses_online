package com.qingguatang.java5minute.course7;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MusicControl {
    private  static final Map<String,String> musics =new HashMap<>();

    @RequestMapping(value="/song/music")
    @ResponseBody
    public String getMusicSrc(String songId){
        return musics.get(songId);
    }

    @PostConstruct     //先初始化执行
    public void  init(){
        musics.put("35847388",
                "http://m10.music.126.net/20180708112712/d0a0c847cbeca7326e1665fe406d4eac/ymusic/de9a/6885/e183/effb8f74546c98fd619d51f22e2bfaaf.mp3");
        musics.put("1635049",
                "http://m10.music.126.net/20180708154558/2285b97fcf5ea1874f9280289e2cee73/ymusic/9321/d812/98ae/5293993463c1bf9dc86fa33d730a6321.mp3");
    }
}


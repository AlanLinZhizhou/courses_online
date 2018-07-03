package com.qingguatang.java5minute.course1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
    @RequestMapping(value="/")   //提供路由信息，后面配置的url会映射到当前方法来处理
    @ResponseBody      //返回对象自动转换为json模式
   public String hello(){
       String mes="hello";
       return mes;
   }
}

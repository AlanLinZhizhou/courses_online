package com.qingguatang.java5minute.course9;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GlobalExceptionHandler implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {

        ModelAndView mav=new ModelAndView();
        mav.addObject("url",request.getRequestURL());
        mav.addAllObjects(model);             //传递页面的上下文信息
        mav.setViewName("error");             //查找Templetes下的error.html文件
        return mav;
    }
}

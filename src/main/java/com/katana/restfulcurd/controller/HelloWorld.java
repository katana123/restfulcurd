package com.katana.restfulcurd.controller;

import com.katana.restfulcurd.dao.ArticleRepository;
import com.katana.restfulcurd.entity.Article;
import com.katana.restfulcurd.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorld {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map,
                        @RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNoStr) {
        int pageNo = 1;

        try {
            pageNo = Integer.parseInt(pageNoStr);
            if (pageNo < 1) {
                pageNo = 1;
            }
        } catch (Exception e) {
        }
        Page<Article> articlePage = articleService.findAllPageable(pageNo - 1);
        map.put("articles", articlePage);
        return "articleList";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}

package com.sm.blog.controller;


import com.sm.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 'zhuyajun@maoyan.com123
 * @since 2018-04-13
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;


    @RequestMapping("detail/{id}")
    @ResponseBody
    public Object getArticle(Long id){
        return articleService.selectById(id);
    }
}


package com.sm.blog.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.sm.blog.model.Article;
import com.sm.blog.service.IArticleService;
import com.sm.core.base.controller.BaseController;
import com.sm.core.base.warpper.ResultWarpper;
import com.sm.core.support.HttpKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController{
    @Autowired
    private IArticleService articleService;

    @RequestMapping("/detail/{id}")
    public ResultWarpper getDetail(@PathVariable("id") Long id){
        int a = 1/0;
        return getSuccess(articleService.selectById(id));
    }

    @RequestMapping("/list")
    public Page<Article> getList(String condition){
        System.out.println(HttpKit.getIp());
        Page<Article> page = new Page<>(1,10);
        return articleService.selectPage(page);
    }
}


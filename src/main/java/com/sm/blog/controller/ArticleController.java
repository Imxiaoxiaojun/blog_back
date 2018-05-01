package com.sm.blog.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.sm.blog.model.Article;
import com.sm.blog.model.Tag;
import com.sm.blog.model.vo.ArticleVo;
import com.sm.blog.service.IArticleService;
import com.sm.blog.service.IArticleTagService;
import com.sm.blog.service.ICommentService;
import com.sm.blog.service.ITagService;
import com.sm.core.base.annotion.IPFilter;
import com.sm.core.base.controller.BaseController;
import com.sm.core.base.warpper.ResultWarpper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private IArticleTagService iArticleTagService;
    @Autowired
    private ITagService iTagService;
    @Autowired
    private ICommentService iCommentService;

    @RequestMapping("/detail/{id}")
    @IPFilter("文章详情")
    public ResultWarpper getDetail(@PathVariable("id") Long id){
        return getSuccess(articleService.selectById(id));
    }

    @RequestMapping("/list")
    public Page getList(String title, Long tagId){
        Page<Article> page = this.getPage(15);
        Page articlePage = articleService.selectPage(page);
        List<Article> articles = articlePage.getRecords();
        List<ArticleVo> articleVos = new ArrayList<>();
        articlePage.setRecords(articleVos);
        for (Article article: articles){
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(article,articleVo);
            List<Long> ids = iArticleTagService.getTagIds(article.getId());
            if (!CollectionUtils.isEmpty(ids)){
                List<Tag> tags = iTagService.selectBatchIds(ids);
                articleVo.setTagList(tags);
            }
            articleVo.setCommentNum(iCommentService.getCountByArticleId(article.getId()));
            articleVos.add(articleVo);
        }
        return articlePage;
    }

    @RequestMapping(value = "/hotList", method = RequestMethod.GET)
    @JsonFilter("id")
    public List<Article> getHotList(){
       return articleService.getHotArticles();
    }

}


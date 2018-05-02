package com.sm.blog.service;

import com.baomidou.mybatisplus.service.IService;
import com.sm.blog.model.Article;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
public interface IArticleService extends IService<Article> {
    List<Article> getHotArticles();
    void updateHit(Long articleId);
}

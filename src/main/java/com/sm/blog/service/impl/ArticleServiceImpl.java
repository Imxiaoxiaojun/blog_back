package com.sm.blog.service.impl;

import com.sm.blog.model.Article;
import com.sm.blog.dao.ArticleMapper;
import com.sm.blog.service.IArticleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getHotArticles() {
        return articleMapper.getHotArticles();
    }

    @Override
    @Transactional
    public void updateHit(Long articleId) {
        articleMapper.updateHit(articleId);
    }
}

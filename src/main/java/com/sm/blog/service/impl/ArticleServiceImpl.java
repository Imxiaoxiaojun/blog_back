package com.sm.blog.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sm.blog.dao.ArticleMapper;
import com.sm.blog.model.Article;
import com.sm.blog.service.IArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 'zhuyajun@maoyan.com123
 * @since 2018-04-13
 */
@Service
@Transactional
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;
}

package com.sm.blog.service.impl;

import com.sm.blog.model.ArticleTag;
import com.sm.blog.dao.ArticleTagMapper;
import com.sm.blog.service.IArticleTagService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements IArticleTagService {
    @Resource
    private ArticleTagMapper articleTagMapper;
    @Override
    public List<Long> getTagIds(Long articleId) {
        return articleTagMapper.getTagIds(articleId);
    }
    @Override
    public Integer getCountByTagId(Long tagId) {
        return articleTagMapper.getCountByTagId(tagId);
    }
}

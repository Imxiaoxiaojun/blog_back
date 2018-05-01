package com.sm.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sm.blog.model.Article;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> getHotArticles();
}

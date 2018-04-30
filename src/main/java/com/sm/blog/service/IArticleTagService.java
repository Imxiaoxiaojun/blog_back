package com.sm.blog.service;

import com.sm.blog.model.ArticleTag;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
public interface IArticleTagService extends IService<ArticleTag> {
    List<Long> getTagIds(Long articleId);
    Integer getCountByTagId(Long tagId);
}

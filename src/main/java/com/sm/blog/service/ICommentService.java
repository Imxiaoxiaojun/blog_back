package com.sm.blog.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.sm.blog.model.Comment;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
public interface ICommentService extends IService<Comment> {
    Integer getCountByArticleId(Long articleId);
    Page<Comment> getList(Page<Comment> page, Long articleId);
}

package com.sm.blog.service;

import com.sm.blog.model.Comment;
import com.baomidou.mybatisplus.service.IService;

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
}

package com.sm.blog.service.impl;

import com.sm.blog.model.Comment;
import com.sm.blog.dao.CommentMapper;
import com.sm.blog.service.ICommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public Integer getCountByArticleId(Long articleId) {
        return commentMapper.getCountByArticleId(articleId);
    }
}

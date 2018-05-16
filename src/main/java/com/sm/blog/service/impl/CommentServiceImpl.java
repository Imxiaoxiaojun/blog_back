package com.sm.blog.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sm.blog.dao.CommentMapper;
import com.sm.blog.model.Comment;
import com.sm.blog.service.ICommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public Integer getCountByArticleId(Long articleId) {
        return commentMapper.getCountByArticleId(articleId);
    }

    @Override
    public Page<Comment> getList(Page<Comment> page, Long articleId) {
        List<Comment> list = commentMapper.getList(page,articleId);
        return page.setRecords(list);
    }
}

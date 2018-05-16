package com.sm.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.sm.blog.model.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("select count(1) from comment where article_id = #{articleId}")
    Integer getCountByArticleId(@Param("articleId") Long articleId);

    List<Comment> getList(Pagination page, Long articleId);
}

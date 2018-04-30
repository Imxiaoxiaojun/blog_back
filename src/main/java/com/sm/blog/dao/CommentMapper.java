package com.sm.blog.dao;

import com.sm.blog.model.Comment;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}

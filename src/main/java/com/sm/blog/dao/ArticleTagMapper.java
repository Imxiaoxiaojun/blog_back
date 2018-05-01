package com.sm.blog.dao;

import com.sm.blog.model.ArticleTag;
import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
    List<Long> getTagIds(Long articleId);

    @Select("select count(1) from article_tag where tag_id = #{tagId}")
    Integer getCountByTagId(@Param("tagId") Long tagId);
}

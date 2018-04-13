package com.sm.blog.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 'zhuyajun@maoyan.com123
 * @since 2018-04-13
 */
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String title;
    private String content;
    /**
     * 概述
     */
    private String summary;
    /**
     * 点击数
     */
    private Integer hits;
    @TableField("image_url")
    private String imageUrl;
    /**
     * 文章类型
     */
    @TableField("category_id")
    private Long categoryId;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_timUe")
    private Date updateTimue;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTimue() {
        return updateTimue;
    }

    public void setUpdateTimue(Date updateTimue) {
        this.updateTimue = updateTimue;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", summary=" + summary +
        ", hits=" + hits +
        ", imageUrl=" + imageUrl +
        ", categoryId=" + categoryId +
        ", createTime=" + createTime +
        ", updateTimue=" + updateTimue +
        "}";
    }
}

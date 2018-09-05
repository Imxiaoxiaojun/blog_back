package com.sm.blog.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 'zhuyajun@maoyan.com123
 * @since 2018-04-29
 */
public class Banner extends Model<Banner> {

    private static final long serialVersionUID = -2941172414683679607L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("banner_name")
    private String bannerName;
    /**
     * 图片标题
     */
    @TableField("banner_url")
    private String bannerUrl;
    @TableField("banner_type")
    private String bannerType;
    /**
     * 创建人
     */
    private String creator;
    @TableField("create_time")
    private Date createTime;
    /**
     * 最后访问时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 简介
     */
    @TableField("banner_intro")
    private String bannerIntro;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerType() {
        return bannerType;
    }

    public void setBannerType(String bannerType) {
        this.bannerType = bannerType;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBannerIntro() {
        return bannerIntro;
    }

    public void setBannerIntro(String bannerIntro) {
        this.bannerIntro = bannerIntro;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Banner{" +
        "id=" + id +
        ", bannerName=" + bannerName +
        ", bannerUrl=" + bannerUrl +
        ", bannerType=" + bannerType +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", bannerIntro=" + bannerIntro +
        "}";
    }
}

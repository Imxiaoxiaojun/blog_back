package com.sm.blog.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
@TableName("ip_log")
public class IpLog extends Model<IpLog> {

    private static final long serialVersionUID = 2935346003777062226L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * SESSION_ID
     */
    private String sid;
    private String ip;
    /**
     * 最后访问时间
     */
    @TableField("visit_time")
    private Date visitTime;
    /**
     * IP对应的区域
     */
    private String area;
    /**
     * 访问路径
     */
    private String uri;
    /**
     * 时间
     */
    @TableField("response_time")
    private Long responseTime;
    /**
     * 访问URI次数
     */
    @TableField("visit_num")
    private Integer visitNum;
    private String referer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "IpLog{" +
        "id=" + id +
        ", sid=" + sid +
        ", ip=" + ip +
        ", visitTime=" + visitTime +
        ", area=" + area +
        ", uri=" + uri +
        ", responseTime=" + responseTime +
        ", visitNum=" + visitNum +
        ", referer=" + referer +
        "}";
    }
}

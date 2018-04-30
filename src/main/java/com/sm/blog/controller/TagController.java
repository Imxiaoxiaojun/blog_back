package com.sm.blog.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.sm.blog.model.Tag;
import com.sm.blog.model.vo.TagVo;
import com.sm.blog.service.IArticleTagService;
import com.sm.blog.service.ITagService;
import com.sm.core.base.controller.BaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
@RestController
@RequestMapping("/tag")
public class TagController extends BaseController{
    @Autowired
    private ITagService iTagService;
    @Autowired
    private IArticleTagService iArticleTagService;

    @RequestMapping("/list")
    public Page<Tag> getList(String condition){
        Page<Tag> page = this.getPage(10);
//        Page<Banner> page = new Page<>(1,10);
        Page tagPage = iTagService.selectPage(page);
        List<Tag> tags = tagPage.getRecords();
        List<TagVo> articleVos = new ArrayList<>();
        tagPage.setRecords(articleVos);
        for (Tag tag: tags){
            TagVo tagVo = new TagVo();
            BeanUtils.copyProperties(tag,tagVo);
            tagVo.setArticleCount(iArticleTagService.getCountByTagId(tag.getId()));
            articleVos.add(tagVo);
        }
        return tagPage;
    }
}


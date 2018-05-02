package com.sm.blog.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.sm.blog.model.Links;
import com.sm.blog.service.ILinksService;
import com.sm.core.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
@RestController
@RequestMapping("/links")
public class LinksController extends BaseController {
    @Autowired
    private ILinksService linksService;

    @RequestMapping("/detail/{id}")
    public Links getDetail(@PathVariable("id") Long id){
       return linksService.selectById(id);
    }
    @RequestMapping("/list")
    public Page<Links> getList(){
        Page<Links> page = this.getPage(15);
        page.setOrderByField("sort");
        page.setAsc(true);
        return linksService.selectPage(page);
    }
}


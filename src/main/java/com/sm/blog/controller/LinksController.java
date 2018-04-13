package com.sm.blog.controller;


import com.sm.blog.model.Links;
import com.sm.blog.service.ILinksService;
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
public class LinksController {
    @Autowired
    private ILinksService linksService;

    @RequestMapping("/detail/{id}")
    public Links getDetail(@PathVariable("id") Long id){
       return linksService.selectById(id);
    }
}


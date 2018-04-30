package com.sm.blog.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.sm.blog.model.Banner;
import com.sm.blog.service.IBannerService;
import com.sm.core.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 'zhuyajun@maoyan.com123
 * @since 2018-04-29
 */
@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController {
    @Autowired
    private IBannerService iBannerService;
    @RequestMapping("/list")
    public Page<Banner> getList(String condition){
        Page<Banner> page = this.getPage(10);
//        Page<Banner> page = new Page<>(1,10);
        return iBannerService.selectPage(page);
    }
}


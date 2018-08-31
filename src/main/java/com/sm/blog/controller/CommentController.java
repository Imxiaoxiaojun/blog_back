package com.sm.blog.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.sm.blog.model.Comment;
import com.sm.blog.service.ICommentService;
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
@RequestMapping("/comment")
public class CommentController extends BaseController {
    @Autowired
    private ICommentService commentService;

    @RequestMapping("/list/{id}")
    public Page<Comment> getCommentList(@PathVariable("id") Long id){
        Page<Comment> page = this.getPage(15);

        return commentService.getList(page,id);
    }
    @RequestMapping("/list")
    public Page<Comment> getMessageList(){
        Page<Comment> page = this.getPage(15);
        return commentService.getList(page,0L);
    }

}


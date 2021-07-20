package com.cn.ecig.demo.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.comment.entity.Comment;
import com.cn.ecig.demo.comment.mapper.CommentMapper;
import com.cn.ecig.demo.comment.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-20
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
    @Autowired
    private  CommentMapper commentMapper;

    @Override
    public void insertComment(String rate, String context,String name) {
        Comment comment=new Comment();
        comment.setContext(context);
        comment.setRate(rate);
        comment.setUserName(name);
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> getUserComment(String name) {
        List<Comment> comments=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("userName",name);
        comments=commentMapper.selectList(wrapper);
        return comments;
    }
}

package com.cn.ecig.demo.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.comment.entity.Comment;
import com.cn.ecig.demo.comment.mapper.CommentMapper;
import com.cn.ecig.demo.comment.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.netty.util.collection.CharObjectMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import  com.cn.ecig.demo.comment.controller.run;

import static com.cn.ecig.demo.comment.controller.run.getDATE;

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
    public void insertComment(int rate, String context,String phoneNumber,String companyCode,String status) {
        Comment comment=new Comment();
        comment.setContext(context);
        comment.setRate(rate);
        comment.setPhoneNumber(phoneNumber);
        comment.setStatus(status);
        comment.setCompanyCode(companyCode);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        comment.setUdate(dateString);
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> getUserComment(String phoneNumber) {
        List<Comment> comments=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("phoneNumber",phoneNumber);
        comments=commentMapper.selectList(wrapper);
        return comments;
    }

    @Override
    public int getCountByCode(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("companyCode",code);
        int r=commentMapper.selectCount(wrapper);
        return r;
    }

    @Override
    public List<Comment> getUserCommnetByCode(String phoneNumber, String code) {
        List<Comment> comments=new ArrayList<>();
        QueryWrapper<Comment> Uwrapper=new QueryWrapper();
     Uwrapper.eq("phoneNumber",phoneNumber);
     Uwrapper.eq("companyCode",code);
        comments=commentMapper.selectList(Uwrapper);
        return comments;
    }

    @Override
    public void deleteComment(String phoneNumber, String date) {
        Map<String,Object> map=new HashMap<>();
        map.put("phoneNumber",phoneNumber);
        map.put("udate",date);
        commentMapper.deleteByMap(map);
    }

    @Override
    public List<Comment> getfeedbackyear(String phoneNumber) throws ParseException {
        QueryWrapper wrapper=new QueryWrapper();
        Date current=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wrapper.eq("phoneNumber",phoneNumber);
        wrapper.between("udate",getDATE(current)[3],format.format(current));
        List<Comment> list=commentMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<Comment> getfeedbackmonth(String phoneNumber) throws ParseException {
        QueryWrapper wrapper=new QueryWrapper();
        Date current=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wrapper.eq("phoneNumber",phoneNumber);
        wrapper.between("udate",getDATE(current)[1],format.format(current));
        List<Comment> list=commentMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<Comment> getfeedbackweek(String phoneNumber) throws ParseException {
        QueryWrapper wrapper=new QueryWrapper();
        Date current=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wrapper.eq("phoneNumber",phoneNumber);
        wrapper.between("udate",getDATE(current)[0],format.format(current));
        List<Comment> list=commentMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<Comment> getfeedbackunsolved(String phoneNumber) {

     return commentMapper.getfeedbackunsolved(phoneNumber);
    }
}

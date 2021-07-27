package com.cn.ecig.demo.comment.service;

import com.cn.ecig.demo.comment.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-20
 */
public interface ICommentService extends IService<Comment> {
    //用户反馈
    void insertComment(int rate,String context,String phoneNumber,String companyCode,String status);

    //获取用户反馈列表
   List<Comment> getUserComment(String phoneNumber);
   //获取对应公司的反馈数镆
    int getCountByCode(String code);

   //根据companycode获取对应的用户反馈列表
    List<Comment> getUserCommnetByCode(String phoneNumber,String code);
    //删除反馈
    void deleteComment(String phoneNumber,String context);
    //获取获取用户近一年反馈信息
    List<Comment> getfeedbackyear (String phoneNumber) throws ParseException;
    //获取获取用户近一月 反馈信息
    List<Comment> getfeedbackmonth (String phoneNumber) throws ParseException;
    //获取获取用户近一周反馈信息
    List<Comment> getfeedbackweek (String phoneNumber) throws ParseException;
    //获取获取用户近未解决反馈信息
    List<Comment> getfeedbackunsolved (String phoneNumber);
}

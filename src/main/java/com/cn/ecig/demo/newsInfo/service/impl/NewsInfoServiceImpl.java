package com.cn.ecig.demo.newsInfo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.newsInfo.entity.NewsInfo;
import com.cn.ecig.demo.newsInfo.mapper.NewsInfoMapper;
import com.cn.ecig.demo.newsInfo.service.INewsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
@Service
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements INewsInfoService {

    @Autowired
    private NewsInfoMapper newsInfoMapper;
    @Override
    public List<NewsInfo> getNewsListByNum(int num) {
        Random ra=new Random();
        int rs=ra.nextInt(200);
        List<NewsInfo>result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.between("id",106363+ rs,106363+rs+num*20);
        result=newsInfoMapper.selectList(wrapper);
        return result;
    }

    @Override
    public List<NewsInfo> getlocalNewsByNum(int num, String area) {
        List<NewsInfo>result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.like("title",area);
        String sql="limit "+num;
        wrapper.last(sql);
        result=newsInfoMapper.selectList(wrapper);
        return result;
    }
}

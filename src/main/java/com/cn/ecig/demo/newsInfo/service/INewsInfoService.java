package com.cn.ecig.demo.newsInfo.service;

import com.cn.ecig.demo.newsInfo.entity.NewsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
public interface INewsInfoService extends IService<NewsInfo> {
    //获取热点新闻
    List<NewsInfo> getNewsListByNum(int num);

    //获取各地动态信息
    List<NewsInfo> getlocalNewsByNum(int num,String area);
}

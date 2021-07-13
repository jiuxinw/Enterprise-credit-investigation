package com.cn.ecig.demo.newsInfo.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.newsInfo.service.INewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
@RestController
@RequestMapping("/info")
public class NewsInfoController {

    @Autowired
    private INewsInfoService newsInfoService;

    /**
     * 获取热点新闻
     * @param num
     * @return
     */
    @RequestMapping(value = "/hotNews",method = RequestMethod.POST)
    public Result getHotNewsByNum(int num){
        Result result=new Result();
        result.setSuccess(false);
        result.setDatail(null);
        try {
        result.setDatail(newsInfoService.getNewsListByNum(num));
        result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

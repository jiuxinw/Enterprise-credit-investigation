package com.cn.ecig.demo.newsInfo.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.newsInfo.service.INewsInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业财务信息", tags = "获取企业具体信息模块")
public class NewsInfoController {

    @Autowired
    private INewsInfoService newsInfoService;

    /**
     * 获取热点新闻
     *
     * @param num
     * @return
     */
    @ApiOperation("获取热点新闻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "新闻数量", required = true, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取新闻信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/hotNews", method = RequestMethod.POST)
    public Result getHotNewsByNum(int num) {
        Result result = new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取信息失败");
        try {
            result.setCode(1);
            result.setData(newsInfoService.getNewsListByNum(num));
            result.setSuccess("200");
            result.setMsg("获取信息成功");
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}

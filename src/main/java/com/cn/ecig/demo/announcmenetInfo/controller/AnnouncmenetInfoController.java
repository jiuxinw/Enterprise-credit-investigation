package com.cn.ecig.demo.announcmenetInfo.controller;


import com.cn.ecig.demo.announcmenetInfo.service.IAnnouncmenetInfoService;
import com.cn.ecig.demo.config.Result;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-14
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业具体信息模块",tags = "获取企业具体信息模块")
public class AnnouncmenetInfoController {
    
    @Autowired
    private  IAnnouncmenetInfoService announcmenetInfoService;

    //获取企业详细信息
    @ApiOperation("获取企业详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "企业代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "代码查询失败")
    })
    @ResponseBody
    @RequestMapping(value = "/detailInfo",method = RequestMethod.POST)
    public Result getAnnoInfoListByCode(String code){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取企业行政表彰信息失败");
        try {
            result.setData(announcmenetInfoService.getAnnounceByCode(code));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取企业行政表彰信息成功");
            if (announcmenetInfoService.getAnnounceByCode(code).size()==0){
                result.setCode(0);
                result.setMsg("获取企业行政表彰信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}

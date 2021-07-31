package com.cn.ecig.demo.announcmenetInfo.controller;


import com.cn.ecig.demo.announcmenetInfo.service.IAnnouncmenetInfoService;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.companyEvaluation.entity.CompanyEvaluation;
import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.note.Operation;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
@CrossOrigin
@Api(value = "获取企业个体模块",tags = "获取企业个体信息模块通过公司代码")
public class AnnouncmenetInfoController {
    
    @Autowired
    private  IAnnouncmenetInfoService announcmenetInfoService;
//    @Autowired
//    private ICompanyBasicInfoService companyBasicInfoService;
    @Autowired
    private ICompanyEvaluationService companyEvaluationService;
    //获取企业详细信息
    @ApiOperation("获取企业详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "企业代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = -1, message = "企业代码不能为空"),
            @ApiResponse(code = -2, message = "企业代码应为6位"),
            @ApiResponse(code = 1, message = "获取企业行政表彰信息成功"),
            @ApiResponse(code = 400, message = "获取企业行政表彰信息失败,数据库无数据"),
            @ApiResponse(code = 0, message = "获取企业行政表彰信息失败")
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
            if(code.isEmpty()){
                result.setCode(-1);
                result.setMsg("企业代码不能为空");
            }
            else {
                if(code.length()!=6){
                    result.setCode(-2);
                    result.setMsg("企业代码应为6位");
                }else{
                    if (announcmenetInfoService.getAnnounceByCode(code)==null){
                        result.setCode(400);
                        result.setMsg("获取企业行政表彰信息失败,数据库无数据");
                    }
                    result.setData(announcmenetInfoService.getAnnounceByCode(code));
                    result.setSuccess("200");
                    result.setCode(1);
                    result.setMsg("获取企业行政表彰信息成功");
                }}
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("获取某企业综合评价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = -1, message = "企业代码不能为空"),
            @ApiResponse(code = -2, message = "企业代码应为6位"),
            @ApiResponse(code = 1, message = "获取企业综合评价信息成功"),
            @ApiResponse(code = 400, message = "获取企业综合评价信息失败,数据库无数据"),
            @ApiResponse(code = 0, message = "获取企业综合评价信息失败"),
    })
    @ResponseBody
    @RequestMapping(value = "/evaluationInfo",method = RequestMethod.POST)
    public Result getFinanceInfoByCode(String code){
        Result result=new Result();
        result.setSuccess("-1");
        Random r = new Random();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取企业综合评价信息失败");
        try {
            if(code.isEmpty()){
                result.setCode(-1);
                result.setMsg("企业代码不能为空");
            }
            else {
                if(code.length()!=6){
                    result.setCode(-2);
                    result.setMsg("企业代码应为6位");
                }else{
                    CompanyEvaluation companyEvaluation=companyEvaluationService.getCompantEvByCode(code);
                    Map<String,Object> map=new HashMap<>();
                    map.put("score",companyEvaluation.getScore());
                    map.put("complete",r.nextInt(100));
                    map.put("rank",r.nextInt(1000));
                    map.put("level",companyEvaluation.getLevel());
                    map.put("adviceRatio",companyEvaluation.getAdviceRatio());
                    result.setData(map);
                    result.setCode(1);
                    result.setMsg("获取企业综合评价信息成功");
                    if(companyEvaluationService.getCompantEvByCode(code)==null){
                        result.setCode(0);
                        result.setMsg("获取企业综合评价信息失败,数据库无数据");
                    }
                }}
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    //获取企业详细信息
    @ApiOperation("获取一段时间内企业公告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "企业代码",required = true,dataType = "String"),
            @ApiImplicitParam(name = "from",value = "开始日期",required = true,dataType = "String"),
            @ApiImplicitParam(name = "to",value = "截止日期",required = true,dataType = "String"),
    })
    @ApiResponses({
            @ApiResponse(code = -1, message = "企业代码不能为空"),
            @ApiResponse(code = -2, message = "企业代码应为6位"),
            @ApiResponse(code = 1, message = "获取一段时间内企业公告信息成功"),
            @ApiResponse(code = 400, message = "获取一段时间内企业公告信息,数据库无数据"),
            @ApiResponse(code = 0, message = "获取一段时间内企业公告信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/essentialInfoDuring",method = RequestMethod.POST)
    public Result getessentialInfoDuring(String code,String from,String to){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取一段时间内企业公告信息失败");
        try {
            if(code.isEmpty()){
                result.setCode(-1);
                result.setMsg("企业代码不能为空");
            }
            else {
                if(code.length()!=6){
                    result.setCode(-2);
                    result.setMsg("企业代码应为6位");
                }else{
                    if (announcmenetInfoService.getANNounceBycODEaN(code, from, to)==null){
                        result.setCode(400);
                        result.setMsg("获取一段时间内企业公告信息,数据库无数据");
                    }
                    result.setData(announcmenetInfoService.getANNounceBycODEaN(code, from, to));
                    result.setSuccess("200");
                    result.setCode(1);
                    result.setMsg("获取一段时间内企业公告信息成功");
                }}
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
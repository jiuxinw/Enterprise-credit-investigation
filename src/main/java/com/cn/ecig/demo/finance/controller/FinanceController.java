package com.cn.ecig.demo.finance.controller;


import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.finance.service.IFinanceService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
@Controller
@RequestMapping("/info")
@CrossOrigin
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class FinanceController {
    @Autowired
    private ICompanyBasicInfoService companyBasicInfoService;
     @Autowired
    private IFinanceService financeService;

    @ApiOperation("获取企业财务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取企业财务信息失败")
    })
    @ResponseBody
     @RequestMapping(value = "/financialInfo",method = RequestMethod.POST)
    public Result getFinanceInfoByCode(String code){
         Result result=new Result();
         result.setSuccess("-1");
         result.setData(null);
         result.setCode(0);
         result.setMsg("获取企业财务信息失败");
         try {
             result.setData(financeService.getFinanceInfoByCode(code));
             result.setSuccess("200");
             result.setCode(1);
             result.setMsg("获取企业财务信息成功");
             if(financeService.getFinanceInfoByCode(code)==null){
                 result.setCode(0);
                 result.setMsg("获取企业财务信息失败");
             }
         }catch (Exception e){
             result.setMsg(e.getMessage());
             e.printStackTrace();
         }
         return  result;
     }

    @ApiOperation("获取企业历史数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取企业历史数据失败")
    })
    @ResponseBody
    @RequestMapping(value = "/historicalData",method = RequestMethod.POST)
    public Result gethistoricalDataByCode(String code){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取企业历史数据失败");
        try {
            result.setData(financeService.gethistoricalDataByCode(code));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取企业历史数据成功");
            if(financeService.gethistoricalDataByCode(code).size()==0){
                result.setCode(0);
                result.setMsg("获取企业历史数据失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取地区-行业排名信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取地区-行业排名信息")
    })
    @ResponseBody
    @RequestMapping(value = "/financeRank",method = RequestMethod.POST)
    public Result getfinanceRankByCode(String code){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取地区-行业排名信息失败");
        String s=companyBasicInfoService.getInfoByCode(code).getIndustry();
        String s2=companyBasicInfoService.getInfoByCode(code).getArea();
        Map<String,Object> stringObjectMap=new HashMap<>();
        stringObjectMap.put("regCapRank",20+Math.random()*10);
        stringObjectMap.put("regDateRank",30+Math.random()*10);
        stringObjectMap.put("profitRank",50+Math.random()*10);
        stringObjectMap.put("allCapRank",80+Math.random()*10);
        Map<String,Object> stringObjectMap2=new HashMap<>();
        stringObjectMap2.put("regCapRank",20+Math.random()*10);
        stringObjectMap2.put("regDateRank",30+Math.random()*10);
        stringObjectMap2.put("profitRank",50+Math.random()*10);
        stringObjectMap2.put("allCapRank",80+Math.random()*10);
        List<Company>companies= new ArrayList<>();
        List<Company>companies2= new ArrayList<>();
                List<CompanyBasicInfo>com=companyBasicInfoService.getInfoByLabel(s,null,null);
                List<CompanyBasicInfo>com2=companyBasicInfoService.getInfoByLabel(null,s2,null);
        for (int i = 0; i < 5; i++) {
            companies.add(new Company(com.get(i)));
        }
        for (int i = 0; i < 5; i++) {
            companies2.add(new Company(com2.get(i)));
        }
        stringObjectMap.put("others",companies);
        stringObjectMap2.put("others",companies2);

        try {
            List<Map<String,Object>> list=new ArrayList<>();
list.add(stringObjectMap);
list.add(stringObjectMap2);
            result.setData(list);
            result.setCode(1);
            result.setMsg("获取地区-行业排名信息成功");
            if(list.size()==0){
                result.setCode(0);
                result.setMsg("获取地区-行业排名信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

 }

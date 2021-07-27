package com.cn.ecig.demo.finance.controller;


import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.finance.service.IFinanceService;
import com.cn.ecig.demo.top100Company.service.ITop100CompanyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
@Api(value = "获取企业个体模块",tags = "获取企业个体信息模块通过公司代码")
public class FinanceController {
    @Autowired
    private ICompanyBasicInfoService companyBasicInfoService;
     @Autowired
    private IFinanceService financeService;
@Autowired
private ITop100CompanyService top100CompanyService;
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
             if(code.isEmpty()){
                 result.setCode(-1);
                 result.setMsg("企业代码不能为空");
             }
             else {
                 if(code.length()!=6){
                     result.setCode(-2);
                     result.setMsg("企业代码应为6位");
                 }else{
                     result.setData(financeService.getFinanceInfoByCode(code));
                     result.setCode(1);
                     result.setMsg("获取企业财务信息成功");
                     if(financeService.getFinanceInfoByCode(code)==null){
                         result.setCode(0);
                         result.setMsg("获取企业财务信息失败,数据库无数据");
                     }
                 }}
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
            @ApiResponse(code = 1, message = "获取企业历史数据成功"),
            @ApiResponse(code = 0, message = "获取企业历史数据失败"),
            @ApiResponse(code = 400, message = "获取企业历史数据失败,数据库无数据"),
            @ApiResponse(code = -1, message = "企业代码不能为空"),
            @ApiResponse(code = -2, message = "企业代码应为6位")
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
            if(code.isEmpty()){
                result.setCode(-1);
                result.setMsg("企业代码不能为空");
            }
            else {
                if(code.length()!=6){
                    result.setCode(-2);
                    result.setMsg("企业代码应为6位");
                }else{
                    result.setData(financeService.gethistoricalDataByCode(code));
                    result.setSuccess("200");
                    result.setCode(1);
                    result.setMsg("获取企业历史数据成功");
                    if(financeService.gethistoricalDataByCode(code).size()==0){
                        result.setCode(400);
                        result.setMsg("获取企业历史数据失败,数据库无数据");
                    }
                }}

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
            @ApiResponse(code = 1, message = "获取地区-行业排名信息成功"),
            @ApiResponse(code = 0, message = "获取地区-行业排名信息失败")  ,
            @ApiResponse(code = 400, message = "获取地区-行业排名信息失败,数据库无数据"),
            @ApiResponse(code = -1, message = "企业代码不能为空"),
            @ApiResponse(code = -2, message = "企业代码应为6位")
    })
    @ResponseBody
    @Async("taskExecutor")
    @RequestMapping(value = "/financeRank",method = RequestMethod.POST)
    public Result getfinanceRankByCode(String code){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取地区-行业排名信息失败");
        Thread thread=new Thread();
       CompanyBasicInfo companyBasicInfo= companyBasicInfoService.getInfoByCode(code);
        String s=companyBasicInfo.getIndustry();
        String s2=companyBasicInfo.getArea();
        Map<String,Object> stringObjectMap=new HashMap<>();
        stringObjectMap.put("regCapRank",format1(20+Math.random()*10));
        stringObjectMap.put("regDateRank",format1(30+Math.random()*10));
        stringObjectMap.put("profitRank",format1(50+Math.random()*10));
        stringObjectMap.put("allCapRank",format1(80+Math.random()*10));
        Map<String,Object> stringObjectMap2=new HashMap<>();
        stringObjectMap2.put("regCapRank",format1(20+Math.random()*10));
        stringObjectMap2.put("regDateRank",format1(30+Math.random()*10));
        stringObjectMap2.put("profitRank",format1(50+Math.random()*10));
        stringObjectMap2.put("allCapRank",format1(80+Math.random()*10));
//        List<Company>companies= new ArrayList<>();
//        List<Company>companies2= new ArrayList<>();
//        List<CompanyBasicInfo>com=companyBasicInfoService.getInfoByLabel(s,null,null);
//        List<CompanyBasicInfo>com2=companyBasicInfoService.getInfoByLabel(null,s2,null);
//        for (int i = 0; i < 5; i++) {
//            companies.add(new Company(com.get(i)));
//        }
//        for (int i = 0; i < 5; i++) {
//            companies2.add(new Company(com2.get(i)));
//        }
//        stringObjectMap.put("others",companies);
//        stringObjectMap2.put("others",companies2);

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
                    List<Map<String,Object>> list=new ArrayList<>();
                    list.add(stringObjectMap);
                    list.add(stringObjectMap2);
                    result.setData(list);
                    result.setCode(1);
                    result.setMsg("获取地区-行业排名信息成功");
                    if(list.size()==0){
                        result.setCode(400);
                        result.setMsg("获取地区-行业排名信息失败,数据库无数据");
                    }
                }}
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取省份企业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province",value = "省份",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "获取省份企业信息成功"),
            @ApiResponse(code = -1, message = "获取省份企业信息失败"),
            @ApiResponse(code = 400, message = "获取企业历史数据失败,数据库无数据"),
    })
    @ResponseBody
    @RequestMapping(value = "/provinceInfo",method = RequestMethod.POST)
    public Result getprovinceInfoByPro (String province){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取省份企业信息");
        try {
            Map<String,Object> map=new HashMap<>();
            map.put("num",companyBasicInfoService.getNumByProvince(province));
            map.put("companyName",financeService.getBigest(province));
            map.put("numOfEnterprise",top100CompanyService.getNumByProvince(province));
            map.put("industry",financeService.getBestIndustry(province));
            map.put("goodCompany",financeService.getGood(province));
            map.put("bigCompany",financeService.getBigAssetsList(province));
                    result.setData(map);
                    result.setSuccess("200");
                    result.setCode(1);
                    result.setMsg("获取省份企业信息成功");
                    if(financeService.getBigest(province)==null){
                        result.setCode(400);
                        result.setMsg("获取省份企业信息成功,数据库无数据");
                    }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
    /**
     * 保留两位小数点
     * @param value
     * @return
     */
    public static String format1(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }

 }

package com.cn.ecig.demo.badCompany.controller;


import com.alibaba.fastjson.JSON;
import com.cn.ecig.demo.badCompany.entity.BadCompany;
import com.cn.ecig.demo.badCompany.service.IBadCompanyService;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.config.Result;
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
public class BadCompanyController {

    @Autowired
    private IBadCompanyService badCompanyService;

    /**
     *
     * @param num
     * @return
     */
    @ApiOperation("旧的获取失信企业排名信息222")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num",value = "请求数",required = true,dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "请求失败")
    })
    @ResponseBody
    @RequestMapping(value = "/badRankInfo2",method = RequestMethod.POST)
    public Result getBadRankInfoByNum2(int num){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        try {
            result.setData(badCompanyService.getBadRankInfoByNum(num));
            result.setSuccess("200");
            result.setCode(1);
        }catch (Exception e){
            result.setMsg("获取信息失败"+e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取法院强制执行人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num",value = "请求数",required = true,dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "请求失败")
    })
    @ResponseBody
    @RequestMapping(value = "/badMan",method = RequestMethod.POST)
    public String  getBadManByNum(int num){
//        Result result=new Result();
//        result.setSuccess("-1");
//        result.setData(null);
//        result.setCode(0);
        HashMap<String,Object> res=new HashMap<>();

        try {
            List<BadCompany> bad=badCompanyService.getbadManByNum(num);
//            List<String> listName=new ArrayList<>();
            HashMap<String,String> map=new HashMap<>();
            for (int i = 0; i < num; i++) {
                map.put(bad.get(i).getCompanyName(),bad.get(i).getCaseURL());
            }
            res.put("code",200);
            res.put("data",map);
//            result.setData(badCompanyService.getBadRankInfoByNum(num));
//            result.setSuccess("200");
//            result.setCode(1);
        }catch (Exception e){
//            result.setMsg("获取信息失败"+e.getMessage());
            res.put("code",-1);
            res.put("msg","获取法院执行人失败");
            e.printStackTrace();
        }
return JSON.toJSONString(res);
    }

    @ApiOperation("获取市场大体信息")
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "请求失败")
    })
    @ResponseBody
    @RequestMapping(value = "/generalInfo",method = RequestMethod.POST)
    public Result getGeneralInfoByNum(){
        Result result=new Result();
        result.setSuccess("-1");
        HashMap<String,String> map=new HashMap<>();
        result.setData(null);
        result.setCode(0);
        map.put("num",Integer.toString((int) (1389678+Math.random()*1000)));
        map.put("yesterday",Integer.toString((int) (86+Math.random()*1000)));
        map.put("today",Integer.toString((int) (136+Math.random()*1000)));
        try {
            result.setData(map);
            result.setMsg("获取市场大体信息成功");
            result.setCode(1);
        }catch (Exception e){
            result.setMsg("获取市场大体信息失败"+e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

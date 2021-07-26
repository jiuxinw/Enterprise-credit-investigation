package com.cn.ecig.demo.follows.controller;


import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.follows.service.IFollowsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-21
 */
@Controller
@RequestMapping("/user")
@Api(value="注册登录api",tags = "用户模块")
public class FollowsController {

    @Autowired
    private IFollowsService followsService;
@Autowired
private ICompanyBasicInfoService companyBasicInfoService;
    @ApiOperation("用户点击关注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String"),
            @ApiImplicitParam(name = "phoneNumber",value = "用户手机号",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "用户点击关注失败")
    })
    @ResponseBody
    @RequestMapping(value = "/follow",method = RequestMethod.POST)
    public Result getFinanceInfoByCode( String code, String phoneNumber){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("用户点击关注失败");
        try {
            result.setData(followsService.insetOne(code,phoneNumber));
            result.setCode(1);
            result.setMsg("用户点击关注成功");
            if(followsService.insetOne(code,phoneNumber)==null){
                result.setCode(0);
                result.setMsg("用户点击关注失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取用户关注列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoneNumber",value = "手机号码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取用户关注列表失败")
    })
    @ResponseBody
    @RequestMapping(value = "/getUserFollows",method = RequestMethod.POST)
    public Result getUserFollows(@RequestParam String phoneNumber){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户关注列表失败");
        try {
            result.setData(followsService.getComm(phoneNumber));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户关注列表成功");
            if(followsService.getComm(phoneNumber).size()==0){
                result.setCode(0);
                result.setMsg("获取用户关注列表失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("删除用户关注企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String"),
            @ApiImplicitParam(name = "phoneNumber",value = "用户手机号",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "删除用户关注企业成功"),
            @ApiResponse(code = 0, message = "删除用户关注企业失败")
    })
    @ResponseBody
    @RequestMapping(value = "/followdelete",method = RequestMethod.POST)
    public Result followdelete( String code, String phoneNumber){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("删除用户关注企业失败");
        try {
            followsService.deleteFollows(code,phoneNumber);
            result.setCode(1);
            result.setMsg("删除用户关注企业成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("搜索用户关注企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key",value = "关键字",required = true,dataType = "String"),
            @ApiImplicitParam(name = "phoneNumber",value = "用户手机号",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "搜索用户关注企业成功"),
            @ApiResponse(code = 0, message = "搜索用户关注企业失败")
    })
    @ResponseBody
    @RequestMapping(value = "/followsearch",method = RequestMethod.POST)
    public Result followsearch( String key, String phoneNumber){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("搜索用户关注企业失败");
        try {
//        List<CompanyBasicInfo>basicInfoList= companyBasicInfoService.getInfoByKey(key);
//        List<Company> companies=new ArrayList<>();
//            for (CompanyBasicInfo coms:basicInfoList) {
//                companies.add(new Company(coms));
//            }
            result.setData(followsService.getBykey(key, phoneNumber));
            result.setCode(1);
            result.setMsg("搜索用户关注企业成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

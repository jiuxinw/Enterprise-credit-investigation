package com.cn.ecig.demo.follows.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.follows.service.IFollowsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("用户点击关注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String"),
            @ApiImplicitParam(name = "userName",value = "用户名",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "用户点击关注失败")
    })
    @ResponseBody
    @RequestMapping(value = "/follow/{userName}",method = RequestMethod.POST)
    public Result getFinanceInfoByCode(@PathVariable String userName, String code){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("用户点击关注失败");
        try {
            result.setData(followsService.insetOne(code,userName));
            result.setCode(1);
            result.setMsg("用户点击关注成功");
            if(followsService.insetOne(userName,code)==null){
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
            @ApiImplicitParam(name = "userName",value = "用户名",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取用户关注列表失败")
    })
    @ResponseBody
    @RequestMapping(value = "/getUserFollows/{userName}",method = RequestMethod.POST)
    public Result getUserFollows(@PathVariable String userName){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户关注列表失败");
        try {
            result.setData(followsService.getComm(userName));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户关注列表成功");
            if(followsService.getComm(userName).size()==0){
                result.setCode(0);
                result.setMsg("获取用户关注列表失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

}

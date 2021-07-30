package com.cn.ecig.demo.personal.controller;


import com.cn.ecig.demo.account.entity.Account;
import com.cn.ecig.demo.account.service.IAccountService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.personal.service.IPersonalService;
import com.cn.ecig.demo.region.entity.Region;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-28
 */
@Controller
@RequestMapping("/user")
@Api(value="注册登录api",tags = "用户模块")
public class PersonalController {
@Autowired
    private IPersonalService personalService;
@Autowired
private IAccountService accountService;
    @ApiOperation("更新用户信息")
    @ApiImplicitParams(
            {  @ApiImplicitParam(name = "userName",required = false,dataType = "String"),
                    @ApiImplicitParam(name = "phoneNumber",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "gender",required = false,dataType = "String"),
                    @ApiImplicitParam(name = "headUrl",required = false,dataType = "String"),
                    @ApiImplicitParam(name = "address",required = false,dataType = "String"),
                    @ApiImplicitParam(name = "email",required =false,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "更新用户信息成功"),
            @ApiResponse(code = 200001,message = "更新用户信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public Result updatePer( @RequestParam(value = "userName",required = false) String userName,
            @RequestParam(value = "phoneNumber",required = true) String phone,
                         @RequestParam(value = "gender",required = false) String gender,
                         @RequestParam(value = "headUrl",required = false) String headUrl,
                         @RequestParam(value = "address",required = false) String address,
                         @RequestParam(value = "email",required = false) String email

    ){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("更新用户信息失败");
        try {

            result.setData(personalService.updateInfo(userName,phone, gender, headUrl, address, email)+"userName更改为"+userName);
            result.setCode(1);
            result.setMsg("更新用户信息成功");
            if(personalService.updateInfo(userName,phone, gender, headUrl, address, email)==null){
                result.setCode(0);
                result.setMsg("更新用户信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取用户个人信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "phoneNumber",required = true,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户个人信息成功"),
            @ApiResponse(code = 200001,message = "获取用户个人信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/getPersonalInfo",method = RequestMethod.POST)
    public Result updatePer(@RequestParam(value = "phoneNumber",required = true) String phone
                          ){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户个人信息失败");
        try {
            Map<String,Object>map=new HashMap<>();
            map.put("登录信息",accountService.getAccountByPhone(phone));
            map.put("个人信息",personalService.getperonalByPhone(phone));
            result.setData(map);
            result.setCode(1);
            result.setMsg("获取用户个人信息成功");
            if(personalService.getperonalByPhone(phone)==null){
                result.setCode(0);
                result.setMsg("获取用户个人信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

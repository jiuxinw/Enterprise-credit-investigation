package com.cn.ecig.demo.personal.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.personal.service.IPersonalService;
import com.cn.ecig.demo.region.entity.Region;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    @ApiOperation("更新用户信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "phoneNumber",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "age",required = false,dataType = "String"),
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
    public Result updatePer(@RequestParam(value = "phoneNumber",required = true) String phone,
                         @RequestParam(value = "age",required = false) String age,
                         @RequestParam(value = "headUrl",required = false) String headUrl,
                         @RequestParam(value = "address",required = false) String address,
                         @RequestParam(value = "email",required = false) String email){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("更新用户信息失败");
        try {
            result.setData(personalService.updateInfo(phone, age, headUrl, address, email));
            result.setCode(1);
            result.setMsg("更新用户信息成功");
            if(personalService.updateInfo(phone, age, headUrl, address, email)==null){
                result.setCode(0);
                result.setMsg("更新用户信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

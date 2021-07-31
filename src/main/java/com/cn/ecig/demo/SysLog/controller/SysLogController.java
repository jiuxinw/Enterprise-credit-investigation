package com.cn.ecig.demo.SysLog.controller;


import com.cn.ecig.demo.SysLog.service.ISysLogService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.region.entity.Region;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-22
 */
@Controller
@RequestMapping("/user")
@Api(value="注册登录api",tags = "用户模块")
public class SysLogController {
@Autowired
private ISysLogService sysLogService;

    @ApiOperation("huoqu")
    @ApiImplicitParams({

    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "按区域查询失败")
    })
    @ResponseBody
    @RequestMapping(value = "/66",method = RequestMethod.POST)
    public Result getFW(){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("按区域查询失败");
        try {

            result.setData(sysLogService.getHot());
            result.setCode(1);
            result.setMsg("按区域查询成功");
            if(sysLogService.getHot()==null){
                result.setCode(0);
                result.setMsg("按区域查询失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

}

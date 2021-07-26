package com.cn.ecig.demo.footPrint.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.footPrint.service.IFootPrintService;
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
 * @since 2021-07-23
 */
@Controller
@RequestMapping("/user")
@Api(value="注册登录api",tags = "用户模块")
public class FootPrintController {

    @Autowired
    private IFootPrintService footPrintService;

    @ApiOperation("获取用户历史足迹")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取用户历史足迹失败")
    })
    @ResponseBody
    @RequestMapping(value = "/getfootPrint/{userName}",method = RequestMethod.POST)
    public Result getfootPrint(@PathVariable String userName){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户历史足迹失败");
        try {
            result.setData(footPrintService.getFootPrint(userName));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户历史足迹成功");
            if(footPrintService.getFootPrint(userName).size()==0){
                result.setCode(0);
                result.setMsg("获取用户历史足迹失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

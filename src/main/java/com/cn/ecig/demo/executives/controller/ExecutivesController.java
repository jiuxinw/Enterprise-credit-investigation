package com.cn.ecig.demo.executives.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.executives.service.IExecutivesService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@Api(value = "获取企业具体信息模块",tags = "获取企业具体信息模块")
public class ExecutivesController {
        @Autowired
    private IExecutivesService executivesService;

    @ApiOperation("获取企业高管信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "企业代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "代码查询失败")
    })
    @ResponseBody
        @RequestMapping(value = "/executiveInfo",method = RequestMethod.POST)
    public Result getExecutivesInfoByCode(String code){
            Result result=new Result();
            result.setSuccess("-1");
            result.setData(null);
            result.setCode(0);
            result.setMsg("获取高管信息失败");
            try {
                result.setData(executivesService.queryExecLsitByCode(code));
                result.setSuccess("200");
                result.setCode(1);
                result.setMsg("获取高管信息成功");
            }catch (Exception e){
                result.setMsg(e.getMessage());
                e.printStackTrace();
            }
            return result;
        }
}

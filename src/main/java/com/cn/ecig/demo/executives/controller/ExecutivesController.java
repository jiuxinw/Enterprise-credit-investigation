package com.cn.ecig.demo.executives.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.executives.service.IExecutivesService;
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
 * @since 2021-07-13
 */
@Controller
@RequestMapping("/info")
@CrossOrigin
@Api(value = "获取企业个体模块",tags = "获取企业个体信息模块通过公司代码")
public class ExecutivesController {
        @Autowired
    private IExecutivesService executivesService;

    @ApiOperation("获取企业高管信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "企业代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "获取高管信息成功"),
            @ApiResponse(code = 0, message = "获取高管信息失败")  ,
            @ApiResponse(code = 400, message = "获取高管信息失败,数据库无数据"),
            @ApiResponse(code = -1, message = "企业代码不能为空"),
            @ApiResponse(code = -2, message = "企业代码应为6位")
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
                if(code.isEmpty()){
                    result.setCode(-1);
                    result.setMsg("企业代码不能为空");
                }
                else {
                    if(code.length()!=6){
                        result.setCode(-2);
                        result.setMsg("企业代码应为6位");
                    }else{
                        result.setData(executivesService.queryExecLsitByCode(code));
                        result.setSuccess("200");
                        result.setCode(1);
                        result.setMsg("获取高管信息成功");
                        if (executivesService.queryExecLsitByCode(code).size()==0) {
                            result.setCode(400);
                            result.setMsg("获取高管信息失败,数据库无数据");
                        }
                    }}

            }catch (Exception e){
                result.setMsg(e.getMessage());
                e.printStackTrace();
            }
            return result;
        }
}

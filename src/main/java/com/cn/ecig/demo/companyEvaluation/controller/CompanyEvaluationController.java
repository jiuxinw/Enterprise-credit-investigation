package com.cn.ecig.demo.companyEvaluation.controller;


import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.cn.ecig.demo.config.Result;
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
 * @since 2021-07-15
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业具体信息模块",tags = "获取企业具体信息模块")
public class CompanyEvaluationController {

    @Autowired
    private ICompanyEvaluationService companyEvaluationService;
    @ApiOperation("获取某企业综合评价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "企业代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "代码查询失败")
    })
    @ResponseBody
    @RequestMapping(value = "/evaluationInfo",method = RequestMethod.POST)
    public Result getCompanyEvalutionInfoByCode(String code){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取综合评价信息失败");
        try {
            result.setData(companyEvaluationService.getCeByCode(code));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取综合评价信息成功");
            if (companyEvaluationService.getCeByCode(code)==null) {
                result.setCode(0);
                result.setMsg("获取综合评价信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}

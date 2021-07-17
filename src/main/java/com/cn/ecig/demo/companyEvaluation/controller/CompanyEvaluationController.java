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
 * @since 2021-07-16
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class CompanyEvaluationController {

    @Autowired
    private ICompanyEvaluationService companyEvaluationService;
    @ApiOperation("获取某企业综合评价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取某企业综合评价信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/evaluationInfo",method = RequestMethod.POST)
    public Result getFinanceInfoByCode(String code){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取企业综合评价信息失败");
        try {
            result.setData(companyEvaluationService.getCompantEvByCode(code));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取企业综合评价信息成功");
            if(companyEvaluationService.getCompantEvByCode(code)==null){
                result.setCode(0);
                result.setMsg("获取企业综合评价信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取诚信企业排名信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num",value = "请求数",required = true,dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取诚信企业排名信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/goodRankInfo",method = RequestMethod.POST)
    public Result getGoodRankByNum(int num){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取诚信企业排名信息失败");
        try {
            result.setData(companyEvaluationService.getGoodRankByNum(num));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取诚信企业排名信息成功");
            if(companyEvaluationService.getGoodRankByNum(num).size()==0){
                result.setCode(0);
                result.setMsg("获取诚信企业排名信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

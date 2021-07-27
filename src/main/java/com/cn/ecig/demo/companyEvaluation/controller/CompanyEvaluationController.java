package com.cn.ecig.demo.companyEvaluation.controller;


import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.cn.ecig.demo.config.Result;
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
 * @since 2021-07-16
 */
@Controller
@RequestMapping("/info")
@CrossOrigin
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class CompanyEvaluationController {

    @Autowired
    private ICompanyEvaluationService companyEvaluationService;
//    @ApiOperation("获取某企业综合评价信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String")
//    })
//    @ApiResponses({
//            @ApiResponse(code = 1, message = "请求成功"),
//            @ApiResponse(code = 0, message = "获取某企业综合评价信息失败")
//    })
//    @ResponseBody
//    @RequestMapping(value = "/evaluationInfo",method = RequestMethod.POST)
//    public Result getFinanceInfoByCode(String code){
//        Result result=new Result();
//        result.setSuccess("-1");
//        result.setData(null);
//        result.setCode(0);
//        result.setMsg("获取企业综合评价信息失败");
//        try {
//            result.setData(companyEvaluationService.getCompantEvByCode(code));
//            result.setSuccess("200");
//            result.setCode(1);
//            result.setMsg("获取企业综合评价信息成功");
//            if(companyEvaluationService.getCompantEvByCode(code)==null){
//                result.setCode(0);
//                result.setMsg("获取企业综合评价信息失败");
//            }
//        }catch (Exception e){
//            result.setMsg(e.getMessage());
//            e.printStackTrace();
//        }
//        return  result;
//    }

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

    @ApiOperation("按照行业获取诚信企业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num",value = "请求数",required = true,dataType = "int"),
            @ApiImplicitParam(name = "industry",value = "行业",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取诚信企业排名信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/indgoodRankInfo",method = RequestMethod.POST)
    public Result getGoodRankByNumIn(int num,String industry){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("按照行业获取诚信企业信息失败");
        try {
            result.setData(companyEvaluationService.getGoodRankByNumInd(num,industry));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("按照行业获取诚信企业信息成功");
            if(companyEvaluationService.getGoodRankByNumInd(num,industry).size()==0){
                result.setCode(0);
                result.setMsg("按照行业获取诚信企业信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("按照区域获取诚信企业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num",value = "请求数",required = true,dataType = "int"),
            @ApiImplicitParam(name = "area",value = "行业",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "按照区域获取诚信企业排名信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/areadgoodRankInfo",method = RequestMethod.POST)
    public Result getGoodRankByNumArea(int num,String area){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("按照区域获取诚信企业信息失败");
        try {
            result.setData(companyEvaluationService.getGoodRankByNumArea(num,area));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("按照区域获取诚信企业信息成功");
            if(companyEvaluationService.getGoodRankByNumArea(num,area).size()==0){
                result.setCode(0);
                result.setMsg("按照区域获取诚信企业信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取失信企业排名信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num",value = "请求数",required = true,dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取失信企业排名信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/badRankInfo",method = RequestMethod.POST)
    public Result getBadRankByNum(int num){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取失信企业排名信息失败");
        try {
            result.setData(companyEvaluationService.getBadRankByNum(num));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取失信企业排名信息成功");
            if(companyEvaluationService.getBadRankByNum(num).size()==0){
                result.setCode(0);
                result.setMsg("获取失信企业排名信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

package com.cn.ecig.demo.industry.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.industry.service.IIndustryService;
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
 * @since 2021-07-17
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class IndustryController {

    @Autowired
    private IIndustryService iIndustryService;

    @ApiOperation("获取获取时间-行业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "from",value = "起始年份",required = true,dataType = "String"),
            @ApiImplicitParam(name = "to",value = "截至年份",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取获取时间-行业信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/yearIndustryRegion",method = RequestMethod.POST)
    public Result getFyearIndustryRegionByTwo(String from,String to){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取时间-行业信息失败");
        try {
            result.setData(iIndustryService.getByFromAndTo(from, to));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取时间-行业信息成功");
            if(iIndustryService.getByFromAndTo(from, to).size()==0){
                result.setCode(0);
                result.setMsg("获取时间-行业信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

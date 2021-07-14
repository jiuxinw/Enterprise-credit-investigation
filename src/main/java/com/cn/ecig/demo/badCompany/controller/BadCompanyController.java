package com.cn.ecig.demo.badCompany.controller;


import com.cn.ecig.demo.badCompany.service.IBadCompanyService;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
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
 * @since 2021-07-13
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class BadCompanyController {

    @Autowired
    private IBadCompanyService badCompanyService;

    /**
     *
     * @param num
     * @return
     */
    @ApiOperation("获取失信企业排名信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num",value = "请求数",required = true,dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "请求失败")
    })
    @ResponseBody
    @RequestMapping(value = "/badRankInfo",method = RequestMethod.POST)
    public Result getBadRankInfoByNum(int num){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        try {
            result.setData(badCompanyService.getBadRankInfoByNum(num));
            result.setSuccess("200");
            result.setCode(1);
        }catch (Exception e){
            result.setMsg("获取信息失败"+e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

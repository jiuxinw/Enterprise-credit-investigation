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

    @ApiOperation("获取热搜企业种类")
    @ApiImplicitParams({

    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取热搜企业种类失败")
    })
    @ResponseBody
    @RequestMapping(value = "/industry",method = RequestMethod.POST)
    public Result getIndustry(){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取热搜企业种类失败");
        String[] strings={"农、林、牧、渔业","采矿业","制造业","电力、热力、燃气及水生产和供应业","建筑业","交通运输、仓储和邮政业","信息传输、软件和信息技术服务业","批发和零售业","住宿和餐饮业","金融业","房地产业","租赁和商务服务业","科学研究和技术服务业","水利、环境和公共设施管理业","居民服务、修理和其他服务业","教育","卫生和社会工作","文化、体育和娱乐业"};
        try {
            result.setData(strings);
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取热搜企业种类成功");
            if(strings==null
            ){
                result.setCode(0);
                result.setMsg("获取热搜企业种类失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

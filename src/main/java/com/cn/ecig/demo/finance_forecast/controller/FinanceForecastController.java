package com.cn.ecig.demo.finance_forecast.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.finance_forecast.service.IFinanceForecastService;
import io.swagger.annotations.*;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-31
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业个体模块",tags = "获取企业个体信息模块通过公司代码")
public class FinanceForecastController {
@Autowired
    private IFinanceForecastService financeForecastService;

    @ApiOperation("预测企业最高、最低收入预期")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "预测企业最高、最低收入预期请求成功"),
            @ApiResponse(code = 0, message = "预测企业最高、最低收入预期失败")
    })
    @ResponseBody
    @RequestMapping(value = "/forecast",method = RequestMethod.POST)
    public Result getforecast(String code){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("预测企业最高、最低收入预期失败");
        try {
            Map<String ,Object> map=new HashMap<>();
            List<String> max=new ArrayList<>();
            List<String> min=new ArrayList<>();
            for (int i = 1; i <13 ; i++) {
                max.add(financeForecastService.getMax(code,String.valueOf(i)));
                min.add(financeForecastService.getMin(code,String.valueOf(i)));
            }
            map.put("high",max);
            map.put("low",min);
            if(code.isEmpty()){
                result.setCode(-1);
                result.setMsg("企业代码不能为空");
            }
            else {
                if(code.length()!=6){
                    result.setCode(-2);
                    result.setMsg("企业代码应为6位");
                }else{
                    result.setData(map);
                    result.setCode(1);
                    result.setMsg("预测企业最高、最低收入预期成功");
                    if(map==null){
                        result.setCode(0);
                        result.setMsg("预测企业最高、最低收入预期失败,数据库无数据");
                    }
                }}
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

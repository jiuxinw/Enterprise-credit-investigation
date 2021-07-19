package com.cn.ecig.demo.region.controller;


import com.alibaba.fastjson.JSON;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.region.entity.Region;
import com.cn.ecig.demo.region.service.IRegionService;
import io.swagger.annotations.*;
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
 * @since 2021-07-16
 */
@Controller
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class RegionController {
    @Autowired
    private IRegionService regionService;

    @ApiOperation("获取企业财务信息")
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取企业财务信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/info/regionProfit",method = RequestMethod.POST)
    public String getregionProfit(){
//        Result result=new Result();
//        result.setSuccess("-1");
//        result.setData(null);
//        result.setCode(0);
//        result.setMsg("获取地区平均利润和平均营收信息失败");
        List<String> listName=new ArrayList<>();
        List<String> listProfit=new ArrayList<>();
        List<String> listrevenue=new ArrayList<>();
       List<Region> list= regionService.getRegionList();
        Map<String, Object> result = new HashMap<>();
        result.put("code",200);
        try {
            for (int i = 0; i < 5; i++) {
                listName.add(list.get(i).getName());
                listProfit.add(list.get(i).getAveProfit());
                listrevenue.add(list.get(i).getAveIncome());
            }
//            result.put("name",listName);
            String[] names={"北京","上海","深圳","广州","杭州"};
            result.put("name",names);
            result.put("profit",listProfit);
            result.put("Income",listrevenue);
//            result.setData(JSON.toJSONString(listName.toString()+","+listProfit.toString()+","+listrevenue.toString()));
//        //   result.setData(regionService.getRegionList());
//            result.setSuccess("200");
//            result.setCode(1);
//            result.setMsg("获取地区平均利润和平均营收信息成功");
//            if(regionService.getRegionList().size()==0){
//                result.setCode(0);
//                result.setMsg("获取地区平均利润和平均营收信息失败");
//            }
        }catch (Exception e){
//            result.setMsg(e.getMessage());
        result.put("code",-1);
            e.printStackTrace();
        }
        return  JSON.toJSONString(result);
    }

    @ApiOperation("按区域查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "查询区域",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "按区域查询失败")
    })
    @ResponseBody
    @RequestMapping(value = "/search/area",method = RequestMethod.POST)
    public Result getFyearIndustryRegionByTwo(String name){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("按区域查询失败");
        Region regions=regionService.getRegionByName(name);
        HashMap<String,String> re=new HashMap<>();
        try {
            re.put("name",regions.getName());
            re.put("num",regions.getNum());
            re.put("goodNum",regions.getGoodNum());
            re.put("badNum",regions.getBadNum());
            re.put("score",regions.getScore());
            result.setData(re);
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("按区域查询成功");
            if(regionService.getRegionByName(name)==null){
                result.setCode(0);
                result.setMsg("按区域查询失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

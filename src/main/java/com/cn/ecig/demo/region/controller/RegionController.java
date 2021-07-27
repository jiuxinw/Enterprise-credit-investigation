package com.cn.ecig.demo.region.controller;


import com.alibaba.fastjson.JSON;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.region.entity.Region;
import com.cn.ecig.demo.region.service.IRegionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
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

    @ApiOperation("获取省份热力图")
    @ApiImplicitParams({

    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "获取省份热力图成功"),
            @ApiResponse(code = 0, message = "获取省份热力图失败")
    })
    @ResponseBody
    @RequestMapping(value = "/distribution",method = RequestMethod.POST)
    public Result getdistribution(){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取省份热力图失败");
        try {
        List<Map<String ,Object>> list=new ArrayList<>();
        String[] provin={"北京市","上海市","安徽省","湖北省","河南省","河北省",
                "新疆维吾尔自治区","西藏自治区","海南省","黑龙江省","吉林省","山东省",
                "重庆市","陕西省","山西省","宁夏回族自治区","内蒙古自治区","江苏省",
                "浙江省","广西壮族自治区","四川省","青海省","甘肃省","辽宁省","贵州省",
                "云南省","江西省","福建省","广东省","湖南省","台湾省","天津市"};
        String[] pinyin={"beijing.json","shanghai.json","anhui.json","hubei.json","henan.json","hebei.json"
        ,"xinjiang.json","xizang.json","hainan.json","heilongjiang.json","jilin.json",
                "shandong.json","chongqing.json","shanxi.json","sanxi.json","ningxia.json",
                "neimenggu.json", "jiangsu.json","zhejiang.json","guangxi.json","sichuan.json",
                "qinghai.json","gansu.json","liaoning.json","guizhou.json","yunnan.json",
                "jiangxi.json","fujian.json","guangdong.json","hunan.json","taiwan.json", "tianjin.json" };
        for (int i = 0; i <provin.length; i++) {
            Map<String ,Object> map=new HashMap<>();
          Region sregion= regionService.getdistribution(provin[i]);
         map.put ( "name",provin[i]);
         map.put("credit",sregion.getTotalScore());
         map.put("profit",sregion.getAveProfit());
         map.put("num",sregion.getNum());
         map.put("json",pinyin[i]);
            list.add(map);
        }

            result.setData(list);
            result.setCode(1);
            result.setMsg("获取省份热力图成功");

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

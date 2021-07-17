package com.cn.ecig.demo.district.controller;


import com.alibaba.fastjson.JSON;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.district.entity.District;
import com.cn.ecig.demo.district.service.IDistrictService;
import com.cn.ecig.demo.region.entity.Region;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
 * @since 2021-07-17
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class DistrictController {

    @Autowired
    private IDistrictService districtService;

    @ApiOperation("获取地区平均资产情况信息")
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取地区平均资产情况信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/regionAssets",method = RequestMethod.POST)
    public String getregionAssets(){
//        Result result=new Result();
//        result.setSuccess("-1");
//        result.setData(null);
//        result.setCode(0);
   //     result.setMsg("获取地区平均资产情况信息失败");
        List<String> listaveCleanAssets=new ArrayList<>();
        List<String> listaveAssets=new ArrayList<>();
        List<String> listaveDebts=new ArrayList<>();
        List<District> list= districtService.getRegionAssets();
        Map<String, Object> result = new HashMap<>();
        result.put("code",200);
        try {
            for (int i = 0; i < 7; i++) {
                listaveCleanAssets.add(list.get(i).getAveCleanAssets());
                listaveAssets.add(list.get(i).getAveAssets());
                listaveDebts.add(list.get(i).getAveDebts());
            }
            result.put("aveCleanAssets",listaveCleanAssets);
            result.put("aveAssets",listaveAssets);
            result.put("aveDebts",listaveDebts);
//            result.setData(JSON.toJSONString(listName.toString()+","+listProfit.toString()+","+listrevenue.toString()));
//            //   result.setData(regionService.getRegionList());
//            result.setSuccess("200");
//            result.setCode(1);
//            result.setMsg("获取地区平均资产情况信息成功");
//            if(regionService.getRegionList().size()==0){
//                result.setCode(0);
//                result.setMsg("获取地区平均资产情况信息失败");
//            }
        }catch (Exception e){
         //   result.setMsg(e.getMessage());
            result.put("code",-1);
            e.printStackTrace();
        }
        return  JSON.toJSONString(result);
    }
}

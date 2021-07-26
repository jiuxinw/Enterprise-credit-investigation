package com.cn.ecig.demo.regionIndustry.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.region.entity.Region;
import com.cn.ecig.demo.regionIndustry.service.IRegionIndustryService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-26
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class RegionIndustryController {
@Autowired
    private IRegionIndustryService regionIndustryService;

    @ApiOperation("获取时间-地区-行业信息2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "from",value = "开始年份",required = true,dataType = "String"),
            @ApiImplicitParam(name = "to",value = "截至年份",required = true,dataType = "String"),
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "按区域查询失败")
    })
    @ResponseBody
    @RequestMapping(value = "/yearIndustryRegion2",method = RequestMethod.POST)
    public Result getyearIndustryRegion2(@Param("from") String from, @Param("to") String to){

        BigDecimal num1 = new BigDecimal(to);
        BigDecimal num2 = new BigDecimal(from);
        BigDecimal ye = num1.subtract(num2);
       String[]years= new String[ye.intValue()];
        for (int i = 0; i < years.length; i++) {
            years[i]=new BigDecimal(from).subtract(new BigDecimal(1)).toString();
        }
        HashMap<String,Object> re=new HashMap<>();
String[]regions={"北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江","上海","江苏","浙江","安徽","福建"
        ,"江西","山东","河南","湖北","湖南","广东","广西","海南","重庆","四川","贵州","云南","西藏","陕西","甘肃","青海"
        ,"宁夏","新疆"};
String[] industrys={
        "金融业","信息传输、软件和信息技术服务业","教育","农、林、牧、渔业","制造业","房地产业"
};
        List<List<String>> list=new ArrayList<>();
      List<String>list1=new ArrayList<>();
        for (int i = 0; i < regions.length ; i++) {
            for (int j=0;j<6;j++){
                for (int k = 0; k < ye.intValue(); k++) {
            list1.add(regionIndustryService.getScoreByThree(industrys[i],regions[j],years[k]));
        }}}
        for (int i = 0; i < ye.intValue(); i++) {
            re.put(years[i], list.get(i));
        }
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("按区域查询失败");
        try {
            result.setData(re);
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("按区域查询成功");
//            if(regionIndustryService.getScoreByThree(industrys,re)==null){
//                result.setCode(0);
//                result.setMsg("按区域查询失败");
//            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

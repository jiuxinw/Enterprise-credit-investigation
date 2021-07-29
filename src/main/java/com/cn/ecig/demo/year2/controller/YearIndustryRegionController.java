package com.cn.ecig.demo.year2.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.regionIndustry.service.IRegionIndustryService;
import com.cn.ecig.demo.year2.entity.YearIndustryRegion;
import com.cn.ecig.demo.year2.service.IYearIndustryRegionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-28
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class YearIndustryRegionController {
@Autowired
    private IYearIndustryRegionService yearIndustryRegionService;
@Autowired
private IRegionIndustryService regionIndustryService;
    @ApiOperation("终极新生代的获取时间-行业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "from",value = "起始年份",required = true,dataType = "String"),
            @ApiImplicitParam(name = "to",value = "截至年份",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取时间-地区-行业信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/yearIndustryRegionFinal",method = RequestMethod.POST)
    public Result getyearIndustryRegionFinal(String from, String to){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取时间-地区-行业信息失败");
        try {
            BigDecimal num1 = new BigDecimal(to);
            BigDecimal num2 = new BigDecimal(from);
            BigDecimal ye = num1.subtract(num2);
            String[]years= new String[ye.intValue()+1];
            for (int i = 0; i < years.length; i++) {
                years[i]=new BigDecimal(from).add(new BigDecimal(i)).toString();
            }
            List<Map<String , Map<String ,Object>>> mapArrayList=new ArrayList<>();
//            String[]regions={"北京市","天津市","河北省","山西省","内蒙古自治区","辽宁省","吉林省","黑龙江省","上海市","江苏省","浙江省","安徽省","福建省"
//                    ,"江西省","山东省","河南省","湖北省","湖南省","广东省","广西壮族自治区","海南省","重庆市","四川省","贵州省","云南省","西藏自治区","陕西省","甘肃省","青海省"
//                    ,"宁夏回族自治区","新疆维吾尔自治区"};
            String[] industrys={
                    "金融业","科学研究和技术服务业","教育","批发和零售业","制造业","房地产业"
            };  HashMap<String,Map<String,Object>> r=new HashMap<>();

            for (int i = 0; i <6 ; i++) {
                List<YearIndustryRegion> ls=yearIndustryRegionService.getByYearAndIndu(from,to,industrys[i]);
                List<List<String>>  l=   convert(ls);
                HashMap<String,Object> re=new HashMap<>();

//                for(int j=0;j<  years.length;j++){
//                    if(l.get(j)!=null) {
//                        re.put(years[j], l.get(j));
//                    }else{
//                        re.put(years[j],null);
//                    }
//                }
                int n=0;
                for (List<String> s:l
                     ) {
                    n=n% years.length;
                    re.put(years[n],s );
                    n++;
                }
                r.put(industrys[i],re);

            }
//            mapArrayList.add(r);
//            List<String> list1=new ArrayList<>();
//
//            for (String in: industrys
//            ) {
//                HashMap<String,Object> re2=new HashMap<>();
//                for (int k = 0; k < ye.intValue()+1; k++) {
//                    List<String> yearl=new ArrayList<>();
//                    for (String s:industrys
//                    ) {
//                        yearl.add(regionIndustryService.getScoreByThree(in,s,years[k]));
//                    }
//                    re2.put(years[k],yearl);
//                }
//                re.put(in,re2);
//            }
            result.setData(mapArrayList);
            result.setCode(1);
            result.setMsg("获取时间-地区-行业信息成功");
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
    public static List<List<String>> convert(List<YearIndustryRegion> years){
//        List<String>list=new ArrayList<>();
        List<List<String>> res=new ArrayList<>();
        List<YearIndustryRegion> industryRegionList=new ArrayList<>();
        for (YearIndustryRegion y:industryRegionList
             ) {
            String[] s={y.getBeiJing(),y.getTianJin(),y.getHeBei(),y.getShanXi(),
                    y.getNeiMengGu(),y.getLiaoNing(),y.getJiLin(),y.getHeiLongJiang(),
                    y.getShangHai(),y.getJiangSu(),y.getZheJiang(),y.getAnHui(),y.getFuJian(),
                    y.getJiangXi(),y.getShanDong(),y.getHeNan(),y.getHuBei(),y.getHuNan()
            ,y.getGuangDong(),y.getGuangXi(),y.getHaiNan(),y.getChongQing(),y.getSiChuan()
                    ,y.getGuiZhou(),y.getYunNan(),y.getXiZang(),y.getSanXi(),y.getGanSu()
            ,y.getQingHai(),y.getXinJiang()};
            res.add(Arrays.asList(s));

        }
        return res;

    }

}

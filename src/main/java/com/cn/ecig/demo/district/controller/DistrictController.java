package com.cn.ecig.demo.district.controller;


import com.alibaba.fastjson.JSON;
import com.cn.ecig.demo.SysLog.service.ISysLogService;
import com.cn.ecig.demo.comment.service.ICommentService;
import com.cn.ecig.demo.companyBasicInfo.entity.C7;
import com.cn.ecig.demo.companyBasicInfo.entity.Cfinal;
import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.district.entity.District;
import com.cn.ecig.demo.district.service.IDistrictService;
import com.cn.ecig.demo.follows.service.IFollowsService;
import com.cn.ecig.demo.region.entity.Region;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
@CrossOrigin
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class DistrictController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IFollowsService followsService;
     @Autowired
private  ICompanyBasicInfoService companyBasicInfoService;
     @Autowired
     private ICompanyEvaluationService companyEvaluationService;
    @Autowired
    private IDistrictService districtService;
    @Autowired
    private ISysLogService sysLogService;

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


    /**
     *
     * @param
     * @return
     */
    @ApiOperation("获取热搜企业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num",value = "请求数",required = true,dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "代码查询失败"),
    })
    @ResponseBody
    @RequestMapping(value = "/hotEnterprise",method = RequestMethod.POST)
    public Result getHotEnterprise(int num){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取热搜企业信息失败");

        List<CompanyBasicInfo> companyBasicInfoList=companyBasicInfoService.gethotEnterprise(num);
        List<Cfinal> cfinals=new ArrayList<>();
        List<C7> companyist=new ArrayList<>();
        List<Cfinal > cist=new ArrayList<>();
        try {
            for (int i = 0; i <num ; i++) {
//                C7 s=new C7(companyBasicInfoList.get(i));
                Cfinal s=new Cfinal(companyBasicInfoList.get(i) );
                s.setCommentNum(commentService.getCountByCode(s.getCode()));
                s.setFollowsNum(followsService.getCountByCOD(s.getCode()));
//                s.setFeedbackNum(companyEvaluationService.getFeedNumBYcode(s.getCode()));
                s.setHotPo(new Random().nextInt(1000));
                s.setScore(companyEvaluationService.getScore(s.getCode()));
                s.setSearchedNum(sysLogService.getCount(s.getCode()));
                cist.add(s);
//                companyist.add(s);
            }
            result.setMsg("获取热搜企业信息成功");
//            result.setData(companyist);
            result.setData(cist);
            result.setCode(1);

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}

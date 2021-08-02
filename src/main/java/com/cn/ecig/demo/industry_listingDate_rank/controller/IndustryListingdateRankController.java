package com.cn.ecig.demo.industry_listingDate_rank.controller;


import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.industry_listingDate_rank.service.IIndustryListingdateRankService;
import com.cn.ecig.demo.industry_netProfit_rank.service.IIndustryNetprofitRankService;
import com.cn.ecig.demo.industry_totalAssets_rank.service.IIndustryTotalassetsRankService;
import com.cn.ecig.demo.industry_totalStockEquity_rank.service.IIndustryTotalstockequityRankService;
import com.cn.ecig.demo.region_listingDate_rank.service.IRegionListingdateRankService;
import com.cn.ecig.demo.region_netProfit_rank.service.IRegionNetprofitRankService;
import com.cn.ecig.demo.region_totalAssets_rank.service.IRegionTotalassetsRankService;
import com.cn.ecig.demo.region_totalStockEquity_rank.service.IRegionTotalstockequityRankService;
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
 * 前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
@Controller
@RequestMapping("/info")
@Api(value = "获取企业财务信息", tags = "获取企业具体信息模块")
public class IndustryListingdateRankController {
    @Autowired
    private IIndustryListingdateRankService industryListingdateRankService;
    @Autowired
    private IIndustryNetprofitRankService iIndustryNetprofitRankService;
    @Autowired
    private IIndustryTotalassetsRankService iIndustryTotalassetsRankService;
    @Autowired
    private IIndustryTotalstockequityRankService industryTotalstockequityRankService;
    @Autowired
    private IRegionListingdateRankService regionListingdateRankService;
    @Autowired
    private IRegionNetprofitRankService regionNetprofitRankService;
    @Autowired
    private IRegionTotalassetsRankService regionTotalassetsRankService;
    @Autowired
    private IRegionTotalstockequityRankService regionTotalstockequityRankService;
    @Autowired
    private ICompanyBasicInfoService companyBasicInfoService;
    @Autowired
    private ICompanyEvaluationService companyEvaluationService;

    @ApiOperation("获取公司四项数据的排名信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "公司代码", required = true, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "获取公司四项数据的排名信息成功"),
            @ApiResponse(code = 0, message = "获取公司四项数据的排名信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/fourrank", method = RequestMethod.POST)
    public Result getfourrank(String code) {
        Result result = new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取公司四项数据的排名信息");
        try {

            String area = companyBasicInfoService.getRegionByCode(code);
            String ind = industryListingdateRankService.getIndustry(code);
            List<CompanyBasicInfo>list=companyBasicInfoService.getListByArea(ind);
            List<Company> list1=new ArrayList<>();
            for (CompanyBasicInfo c:list
                 ) {
                list1.add(new Company(c));

            }
            Map<String, Object> map = new HashMap<>();
            List<String> in = new ArrayList<>();
            List<String> re = new ArrayList<>();
            in.add(0, regionTotalstockequityRankService.getRank(code));
            in.add(1, regionListingdateRankService.getRank(code));
            in.add(2, regionTotalassetsRankService.getRank(code));
if(regionNetprofitRankService.getRank(code)==null){
    in.add(3,"#");
}else
{
    in.add(3,regionNetprofitRankService.getRank(code));
}

            re.add(0, industryTotalstockequityRankService.getRank(code));
            re.add(1, industryListingdateRankService.getRank(code));
            re.add(2, iIndustryTotalassetsRankService.getRank(code));
            re.add(3, iIndustryNetprofitRankService.getRank(code));

            map.put("provincerank", re);
            map.put("industryrank", in);
            map.put("provincecompany", companyEvaluationService.getGoodRankByNumArea(10, area));
//            map.put("industrycompany", companyEvaluationService.getGoodRankByNumInd2(10, ind));
            map.put("industrycompany",list1);
            if (code.isEmpty()) {

                result.setCode(-1);
                result.setMsg("企业代码不能为空");
            } else {
                if (code.length() != 6) {
                    result.setCode(-2);
                    result.setMsg("企业代码应为6位");
                } else {
                    result.setData(map);
                    result.setCode(1);
                    result.setMsg("获取公司四项数据的排名信息成功");
                    if (map == null) {
                        result.setCode(0);
                        result.setMsg("获取公司四项数据的排名信息失败,数据库无数据");
                    }
                }
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}

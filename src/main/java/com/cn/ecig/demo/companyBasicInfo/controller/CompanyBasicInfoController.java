package com.cn.ecig.demo.companyBasicInfo.controller;


import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
@RestController
@RequestMapping("/search")
public class CompanyBasicInfoController {
@Autowired
private ICompanyBasicInfoService companyBasicInfoService;
    @RequestMapping(value = "/keywords",method = RequestMethod.POST)
    public Result queryByKey(String key){
        Result result=new Result();
        result.setSuccess(false);
        result.setDatail(null);
        try {
        result.setDatail(companyBasicInfoService.getInfoByKey(key));
        result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 按照企业代码查询企业
     * @param code
     * @return
     */
    @RequestMapping(value = "/code",method = RequestMethod.POST)
    public Result queryByCode(String code){
        Result result=new Result();
        result.setSuccess(false);
        result.setDatail(null);
        try {
            result.setDatail(companyBasicInfoService.getInfoByCode(code));
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 按照标签查询
     * @param industry
     * @param area
     * @param transferMode
     * @return
     */
    @RequestMapping(value = "/label",method = RequestMethod.POST)
    public Result queryByLabel (String industry,String area,String transferMode){
        Result result=new Result();
        result.setSuccess(false);
        result.setDatail(null);
        try {
            result.setDatail(companyBasicInfoService.getInfoByLabel(industry, area, transferMode));
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


}

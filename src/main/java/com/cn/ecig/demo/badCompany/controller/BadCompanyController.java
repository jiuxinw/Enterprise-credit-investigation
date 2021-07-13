package com.cn.ecig.demo.badCompany.controller;


import com.cn.ecig.demo.badCompany.service.IBadCompanyService;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
@RestController
@RequestMapping("/info")
public class BadCompanyController {

    @Autowired
    private IBadCompanyService badCompanyService;

    /**
     *
     * @param num
     * @return
     */
    @RequestMapping(value = "/badRankInfo",method = RequestMethod.POST)
    public Result getBadRankInfoByNum(int num){
        Result result=new Result();
        result.setSuccess(false);
        result.setDatail(null);
        try {
            result.setDatail(badCompanyService.getBadRankInfoByNum(num));
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}

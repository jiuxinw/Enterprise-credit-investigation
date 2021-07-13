package com.cn.ecig.demo.finance.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.finance.service.IFinanceService;
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
public class FinanceController {
     @Autowired
    private IFinanceService financeService;

     @RequestMapping(value = "/financialInfo",method = RequestMethod.POST)
    public Result getFinanceInfoByCode(String code){
         Result result=new Result();
         result.setSuccess(false);
         result.setDatail(null);
         try {
             result.setDatail(financeService.getFinanceInfoByCode(code));
             result.setSuccess(true);
         }catch (Exception e){
             result.setMsg(e.getMessage());
             e.printStackTrace();
         }
         return  result;
     }
 }

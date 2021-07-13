package com.cn.ecig.demo.executives.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.executives.service.IExecutivesService;
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
public class ExecutivesController {
        @Autowired
    private IExecutivesService executivesService;

        @RequestMapping(value = "/executiveInfo",method = RequestMethod.POST)
    public Result getExecutivesInfoByCode(String code){
            Result result=new Result();
            result.setSuccess(false);
            result.setDatail(null);
            try {
                result.setDatail(executivesService.queryExecLsitByCode(code));
                result.setSuccess(true);
            }catch (Exception e){
                result.setMsg(e.getMessage());
                e.printStackTrace();
            }
            return result;
        }
}

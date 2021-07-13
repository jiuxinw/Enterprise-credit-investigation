package com.cn.ecig.demo.topTenHolders.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.topTenHolders.service.ITopTenHoldersService;
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
public class TopTenHoldersController {
    @Autowired
    private ITopTenHoldersService topTenHoldersService;

    @RequestMapping(value = "/shareholderInfo",method = RequestMethod.POST)
    public Result getShareHolderInfoByCode(String code){
        Result result=new Result();
        result.setSuccess(false);
        result.setDatail(null);
        try {
            result.setDatail(topTenHoldersService.getShareHoldeInfoByCode(code));
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }return result;
    }
}

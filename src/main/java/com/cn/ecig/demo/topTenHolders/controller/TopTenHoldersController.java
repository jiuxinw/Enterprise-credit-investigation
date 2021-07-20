package com.cn.ecig.demo.topTenHolders.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.topTenHolders.service.ITopTenHoldersService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
@Controller
@RequestMapping("/info")
@CrossOrigin
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class TopTenHoldersController {
    @Autowired
    private ITopTenHoldersService topTenHoldersService;

    @ApiOperation("获取企业股东信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "公司代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取股东信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/shareholderInfo",method = RequestMethod.POST)
    public Result getShareHolderInfoByCode(String code){
        Result result=new Result();
        result.setSuccess("-1");
        result.setCode(0);
        result.setMsg("获取股东信息失败");
        result.setData(null);
        try {
            result.setCode(1);
            result.setData(topTenHoldersService.getShareHoldeInfoByCode(code));
            result.setSuccess("200");
            result.setMsg("获取信息成功");
            if(topTenHoldersService.getShareHoldeInfoByCode(code).size()==0) {
                result.setMsg("获取股东信息失败");
                result.setCode(0);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }return result;
    }
}

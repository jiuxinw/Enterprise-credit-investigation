package com.cn.ecig.demo.companyBasicInfo.controller;


import com.alibaba.fastjson.JSON;
import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.newsInfo.service.INewsInfoService;
import com.cn.ecig.demo.note.Operation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
@Controller
@RequestMapping("/search")
@CrossOrigin
@Api(value = "查询模块",tags = "查询")
public class CompanyBasicInfoController {
@Autowired
private ICompanyBasicInfoService companyBasicInfoService;
@Autowired
private INewsInfoService newsInfoService;
    @Operation("按照关键字查询企业")
    @ApiOperation("按关键字模糊查询企业或新闻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key",value = "关键字",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "查询失败"),
            @ApiResponse(code = -1, message = "关键字不能为空")
    })
    @ResponseBody
    @RequestMapping(value = "/keywords",method = RequestMethod.POST)
    public Result queryByKey(String key){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("查询失败");
        Map<String,Object> map=new HashMap<>();
        try {
            if(key.isEmpty()){
            result.setCode(-1);
            result.setMsg("关键字不能为空");
            }
        else{
            result.setMsg("行业查询成功");

//            result.setData(newsInfoService.getNewsLsitByKey(key));
                map.put("企业",companyBasicInfoService.getInfoByKey(key));
                map.put("新闻",newsInfoService.getNewsLsitByKey(key));
                result.setData(map);
            result.setCode(1);}
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
    @Operation("按照企业代码查询企业")
    @ApiOperation("按照企业代码查询企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "企业代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "代码查询失败"),
            @ApiResponse(code = 200, message = "代码查询成功"),
            @ApiResponse(code = 400, message = "代码查询失败，数据库无数据"),
            @ApiResponse(code = -1, message = "企业代码不能为空")
    })
    @ResponseBody
    @RequestMapping(value = "/code",method = RequestMethod.POST)
    public Result queryByCode(String code){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("代码查询失败");
        try {
            if(code.isEmpty()){
                result.setCode(-1);
                result.setMsg("企业代码不能为空");
            }
            else {
                if(code.length()<6){
                    result.setCode(-2);
                    result.setMsg("企业代码应为6位");
                }else{
                result.setMsg("查询成功");
                result.setData(companyBasicInfoService.getInfoByCode(code));
                    result.setCode(200);
                if(companyBasicInfoService.getInfoByCode(code)==null){
                    result.setMsg("代码查询失败，数据库无数据");
                    result.setCode(400);
                }
            }}
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
//    @Operation("按照标签查询企业")
    @ApiOperation("按照标签查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry",value = "行业",required = false,dataType = "String"),
            @ApiImplicitParam(name = "area",value = "地区",required = false,dataType = "String"),
            @ApiImplicitParam(name = "transferMode",value = "交易方式",required = false,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "行业查询失败")
    })
    @ResponseBody
    @RequestMapping(value = "/label",method = RequestMethod.POST)
    public Result queryByLabel (String industry,String area,String transferMode){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("行业查询失败");
        try {
//            if (industry.isEmpty()&&area.isEmpty()&&transferMode.isEmpty()){
//                result.setData(null);
//                result.setCode(0);
//                result.setMsg("行业查询失败");
//            }else{
            result.setMsg("行业查询成功");
            result.setData(companyBasicInfoService.getInfoByLabel(industry, area, transferMode));
            result.setCode(1);
            if (companyBasicInfoService.getInfoByLabel(industry, area, transferMode).size()==0){
                result.setCode(0);
                result.setMsg("行业查询失败");
            }
       // }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


  @ApiOperation("二代按照标签查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry",value = "行业",required = false,dataType = "String"),
            @ApiImplicitParam(name = "area",value = "地区",required = false,dataType = "String"),
            @ApiImplicitParam(name = "transferMode",value = "交易方式",required = false,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "行业查询失败")
    })
    @ResponseBody
    @RequestMapping(value = "/label2",method = RequestMethod.POST)
    public Result queryByLabel2 (String industry,String area,String transferMode){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
      String[] in=industry.split("\\s+");;
      String[] ar=area.split("\\s+");;
      String[] tr=transferMode.split("\\s+");;
        result.setMsg("行业查询失败");
        try {
//            if (industry.isEmpty()&&area.isEmpty()&&transferMode.isEmpty()){
//                result.setData(null);
//                result.setCode(0);
//                result.setMsg("行业查询失败");
//            }else{
            result.setMsg("行业查询成功");

            result.setData(companyBasicInfoService.getInfoByLabel2(in, ar, tr));
            result.setCode(1);
            if (companyBasicInfoService.getInfoByLabel2(in, ar, tr).size()==0){
                result.setCode(0);
                result.setMsg("行业查询失败");
            }
            // }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    @ApiOperation("通过公司代码请求企业基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "企业代码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "请求企业基本信息失败"),
            @ApiResponse(code = 400, message = "请求企业基本信息失败，数据库无数据"),
            @ApiResponse(code = -1, message = "企业代码不能为空"),
            @ApiResponse(code = -2, message = "企业代码应为6位")
    })
    @ResponseBody
    @RequestMapping(value = "/essentialInfo",method = RequestMethod.POST)
    public Result getessentialInfoByCode(String code){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("请求企业基本信息失败");
        try {
            if(code.isEmpty()){
                result.setCode(-1);
                result.setMsg("企业代码不能为空");
            }
            else {
                if(code.length()!=6){
                    result.setCode(-2);
                    result.setMsg("企业代码应为6位");
                }else{
                    result.setMsg("请求企业基本信息成功");
                    result.setData(companyBasicInfoService.getessentialInfoByCode(code));
                   result.setCode(200);
                   if(companyBasicInfoService.getessentialInfoByCode(code)==null){
                       result.setCode(400);
                       result.setMsg("请求企业基本信息失败,数据库无数据");
                   }
                }}
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static String[]  con(String args) {
        String[] split = args.split("\\s+");
      return split;
    }

}

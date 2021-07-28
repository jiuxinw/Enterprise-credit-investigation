package com.cn.ecig.demo.comment.controller;


import com.cn.ecig.demo.comment.entity.Comment;
import com.cn.ecig.demo.comment.service.ICommentService;
import com.cn.ecig.demo.config.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-20
 */
@Controller
@RequestMapping("/user")
@Api(value="注册登录api",tags = "用户模块")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @ApiOperation("用户反馈")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "phoneNumber",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "rate",required = true,dataType = "int"),
                    @ApiImplicitParam(name = "context",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "companyCode",required = false,dataType = "String"),
                    @ApiImplicitParam(name = "status",required = false,dataType = "String"),
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "添加成功"),
            @ApiResponse(code = 200001,message = "添加失败")
    })
    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Result inComment(
            @RequestParam(value = "phoneNumber",required = true)String phoneNumber,
                         @RequestParam(value = "rate",required = true) int rate,
                         @RequestParam(value = "context",required = true) String context,
                         @RequestParam(value = "companyCode",required = false) String companyCode,
                         @RequestParam(value = "status",required = false) String status
            ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("添加用户反馈失败");
        try {
            commentService.insertComment(rate, context,phoneNumber,companyCode,status);
            result.setData("添加成功");
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("添加用户反馈成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    @ApiOperation("获取用户反馈")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "phoneNumber",required = true,dataType = "String")
//                    @ApiImplicitParam(name = "rate",required = false,dataType = "String"),
//                    @ApiImplicitParam(name = "context",required = false,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户反馈成功"),
            @ApiResponse(code = 200001,message = "获取用户反馈失败")
    })
    @ResponseBody
    @RequestMapping(value = "/getUserComment",method = RequestMethod.POST)
    public Result getUserComment(
            @RequestParam(value = "phoneNumber",required = true)String phoneNumber
            ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户反馈失败");
        try {
            result.setData(commentService.getUserComment(phoneNumber));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户反馈成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    @ApiOperation("获取用户对应具体公司的反馈")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "phoneNumber",required = true,dataType = "String"),
            @ApiImplicitParam(name = "companyCode",required = true,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户对应具体公司反馈成功"),
            @ApiResponse(code = 200001,message = "获取用户对应具体公司反馈失败")
    })
    @ResponseBody
    @RequestMapping(value = "/getCUserComment",method = RequestMethod.POST)
    public Result getUserComment(
            @RequestParam(value = "phoneNumber",required = true)String phoneNumber,
            @RequestParam(value = "companyCode",required = false) String code
    ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户对应具体公司反馈失败");
        try {
            result.setData(commentService.getUserCommnetByCode(phoneNumber, code));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户对应具体公司反馈成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    @ApiOperation("删除用户反馈信息")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "phoneNumber",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "date",required = true,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "删除用户反馈信息成功"),
            @ApiResponse(code = 200001,message = "删除用户反馈信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/deletefeedback",method = RequestMethod.POST)
    public Result deletefeedback(
            @RequestParam(value = "phoneNumber",required = true)String phoneNumber,
            @RequestParam(value = "date",required = true) String date
    ){
        Result result=new Result();
        result.setData(null);
        result.setCode(0);
        result.setMsg("删除用户反馈信息失败");
        try {
            commentService.deleteComment(phoneNumber, date);
            result.setCode(1);
            result.setMsg("删除用户反馈信息成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    @ApiOperation("获取用户近一年反馈")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "phoneNumber",required = true,dataType = "String")
//                    @ApiImplicitParam(name = "rate",required = false,dataType = "String"),
//                    @ApiImplicitParam(name = "context",required = false,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户近一年反馈信息成功"),
            @ApiResponse(code = 200001,message = "获取用户一年近反馈信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/feedbackyear",method = RequestMethod.POST)
    public Result getfeedbackyear(
            @RequestParam(value = "phoneNumber",required = true)String phoneNumber
    ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户近一年反馈信息失败");
        try {
            result.setData(commentService.getfeedbackyear(phoneNumber));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户近一年反馈信息成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }
    @ApiOperation("获取用户近一月反馈")
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户近一月反馈信息成功"),
            @ApiResponse(code = 200001,message = "获取用户近一月反馈信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/feedbackmonth",method = RequestMethod.POST)
    public Result getfeedbackmonth(
            @RequestParam(value = "phoneNumber",required = true)String phoneNumber
    ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户近一月反馈信息失败");
        try {
            result.setData(commentService.getfeedbackmonth(phoneNumber));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户近一月反馈信息成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }
    @ApiOperation("获取用户近一周反馈")
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户近一周反馈信息成功"),
            @ApiResponse(code = 200001,message = "获取用户一年周反馈信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/feedbackweek",method = RequestMethod.POST)
    public Result getfeedbackweek(
            @RequestParam(value = "phoneNumber",required = true)String phoneNumber
    ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户近一周反馈信息失败");
        try {
            result.setData(commentService.getfeedbackweek(phoneNumber));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户近一周反馈信息成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }
    @ApiOperation("获取用户近一年未解决反馈")
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户近一周未解决反馈信息成功"),
            @ApiResponse(code = 200001,message = "获取用户近一周未解决反馈信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/feedbackunsolved",method = RequestMethod.POST)
    public Result getfeedbackunsolved(
            @RequestParam(value = "phoneNumber",required = true)String phoneNumber
    ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户近一周未解决反馈信息失败");
        try {
            result.setData(commentService.getfeedbackunsolved(phoneNumber));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户近一周未解决反馈信息成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

//    /**
//     *
//     * @param month
//     *          指定日期
//     * @param num
//     *          数字
//     * @param dateType
//     *          1：月   2：季度
//     * @param flag
//     *          1：后   2：前
//     * @return
//     * @throws ParseException
//     */
//    public String getDate(String month,int num,String dateType,String flag) throws ParseException {
//        month="20200601";
//        num=1;
//        dateType="2";
//        flag="2";
//        //指定日期格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        Date data = sdf.parse(month);
//        int num1 = num;
//        Calendar rightNow = Calendar.getInstance();
//        rightNow.setTime(data);
//        if("1".equals(dateType)) {
//            num1=num;
//        }else if("2".equals(dateType)) {
//            num1=num*3;
//        }
//        if("1".equals(flag)) {
//        }else {
//            num1=-num1;
//        }
//        rightNow.add(Calendar.MONTH,num1);//日期加几个月
//        Date dt1=rightNow.getTime();
//        String reStr = sdf.format(dt1);
//        System.out.println(reStr);
//        return reStr;
//    }


}

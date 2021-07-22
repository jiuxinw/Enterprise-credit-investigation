package com.cn.ecig.demo.comment.controller;


import com.cn.ecig.demo.comment.entity.Comment;
import com.cn.ecig.demo.comment.service.ICommentService;
import com.cn.ecig.demo.config.Result;
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
            {@ApiImplicitParam(name = "userName",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "rate",required = true,dataType = "String"),
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
    @RequestMapping(value = "/comment/{userName}",method = RequestMethod.POST)
    public Result inComment(
            @PathVariable(value = "userName",required = true)String userName,
                         @RequestParam(value = "rate",required = true) String rate,
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
            commentService.insertComment(rate, context,userName,companyCode,status);
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
            {@ApiImplicitParam(name = "userName",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "rate",required = false,dataType = "String"),
                    @ApiImplicitParam(name = "context",required = false,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户反馈成功"),
            @ApiResponse(code = 200001,message = "获取用户反馈失败")
    })
    @ResponseBody
    @RequestMapping(value = "/getUserComment/{userName}",method = RequestMethod.POST)
    public Result getUserComment(
            @PathVariable(value = "userName",required = true)String userName
            ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户反馈失败");
        try {
            result.setData(commentService.getUserComment(userName));
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
            {@ApiImplicitParam(name = "userName",required = true,dataType = "String"),
            @ApiImplicitParam(name = "companyCode",required = true,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "获取用户对应具体公司反馈成功"),
            @ApiResponse(code = 200001,message = "获取用户对应具体公司反馈失败")
    })
    @ResponseBody
    @RequestMapping(value = "/getCUserComment/{userName}",method = RequestMethod.POST)
    public Result getUserComment(
            @PathVariable(value = "userName",required = true)String userName,
            @RequestParam(value = "companyCode",required = false) String code
    ){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取用户对应具体公司反馈失败");
        try {
            result.setData(commentService.getUserCommnetByCode(userName, code));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取用户对应具体公司反馈成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

}

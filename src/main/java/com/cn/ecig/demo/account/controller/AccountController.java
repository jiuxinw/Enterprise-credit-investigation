package com.cn.ecig.demo.account.controller;


import com.cn.ecig.demo.account.service.IAccountService;
import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.config.Token;
import com.cn.ecig.demo.config.component.TokenManager;
import io.swagger.annotations.*;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-14
 */
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = {"","null"},allowCredentials = "true")
@Api(value="注册登录api",tags = "用户模块")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ICompanyEvaluationService companyEvaluationService;

    @Qualifier("redisTokenManager")
    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(value = "/s",method = RequestMethod.GET)
    @ResponseBody
    public String getSessionId(HttpServletRequest request){
        HttpSession session= request.getSession();
        return session.getId();
    }
    Logger logger= LoggerFactory.getLogger(AccountController.class);
//    @Autowired
//    private Md5TokenGenerator tokenGenerator

//    @RequestMapping(value = "/reg",method = RequestMethod.POST)
//    public String userReg(String phone,String name,String pwd){
//    Map<String,Object> result=new HashMap<>();
//    try {
//     accountService.register(phone, name, pwd);
//        result.put("error",0);
//        result.put("data",phone+","+name+","+pwd);
//
//    }catch (Exception e){
//        result.put("error",20001);
//        result.put("msg",e.getMessage());
//    }
//       return JSON.toJSONString(result);
//    }

    //    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String userLogin(@RequestParam(value = "userName",required = false) String name,
//                            @RequestParam(value = "password",required = false) String pwd){
//    Map<String,Object> result=new HashMap<>();
//    try {
//        accountService.login(name,pwd);
//        result.put("error",0);
//        result.put("msg","sucessful log");
//    }catch (Exception e){
//        result.put("error",300002);
//        result.put("msg","用户名或密码错误");
//    }
//    return JSON.toJSONString(result);
//}
    @ApiOperation("注册")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "phoneNumber",required = true,dataType = "Long"),
                    @ApiImplicitParam(name = "userName",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "password",required = true,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "注册成功"),
            @ApiResponse(code = 200001,message = "注册失败")
    })
    @ResponseBody
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public Result regist(@RequestParam(value = "phoneNumber",required = false) Long phone,
                         @RequestParam(value = "userName",required = false) String name,
                         @RequestParam(value = "password",required = false) String pwd){
        return accountService.regist(phone,name,pwd);

    }
    @ApiOperation("登录")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "name",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "pwd",required = true,dataType = "String")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 0,message = "successful log"),
            @ApiResponse(code = 300002,message = "用户名或者密码错误")
    })
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(String name,String pwd){
        Token token=tokenManager.createToken(name);
        System.out.println(token);
        return accountService.login(name, pwd);

    }




}

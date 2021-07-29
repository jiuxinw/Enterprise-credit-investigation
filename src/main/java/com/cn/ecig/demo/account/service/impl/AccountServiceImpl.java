package com.cn.ecig.demo.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cn.ecig.demo.account.entity.Account;
import com.cn.ecig.demo.account.mapper.AccountMapper;
import com.cn.ecig.demo.account.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.personal.entity.Personal;
import com.cn.ecig.demo.personal.mapper.PersonalMapper;
import com.cn.ecig.demo.personal.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-14
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @Autowired
  private   AccountMapper accountMapper;
    @Autowired
    private IPersonalService personalService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String N;
    @Override
    public Result regist(String phoneNumber, String userName, String password) {
        Account account=new Account(phoneNumber, userName, password);
        Result result=new Result();
        result.setSuccess("注册失败");
        result.setData(null);
        result.setCode(200001);
        try {
            QueryWrapper wrapper=new QueryWrapper();
            wrapper.eq("userName",userName);
            Account exist=accountMapper.selectOne(wrapper) ;
            if (exist!=null && exist.getUserName()!=null){
                //如果用户名已经存在
                result.setData("用户名已经存在");
            }else {
                accountMapper.insert(account);
                personalService.insertPersonByPhone(phoneNumber);
                result.setMsg("注册成功");
                result.setSuccess("200");
                N=userName;
                result.setData(account);
                result.setCode(0);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @Override
    public int updateUserName(String phoneNumber, String useName) {
        Account account=new Account();
        account.setUserName(useName);
        UpdateWrapper wrapper=new UpdateWrapper();
        wrapper.eq("phoneNumber" ,phoneNumber);
        int res=accountMapper.update(account,wrapper);
        return res;
    }

    /**
     * 登录
     * @param //用户名和密码
     * @return Result
     */
    @Override
    public Result login(String phoneNumber,String password) {
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(30002);
        try {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("phoneNumber", phoneNumber);
            Account targetaccount = accountMapper.selectOne(wrapper);
            Map<String,Object>map=new HashMap<>();

            if(targetaccount!=null){
            if (password.equals(targetaccount.getPassword())){
                String url=personalService.getUrlByphone(phoneNumber);
                map.put("登录信息",targetaccount);
                map.put("个人信息",personalService.getperonalByPhone(phoneNumber));
                result.setMsg("登录成功");
                result.setData(map);
                result.setCode(200);
            }else {
                result.setCode(-1);
                result.setMsg("密码错误");
            }
            }
            else {
                result.setCode(-2);
                result.setMsg("用户不存在");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public Account getAccountById(int id) {
        QueryWrapper wrapper=new QueryWrapper();
        Account account=new Account();
        wrapper.eq("aid",id);
        account=accountMapper.selectOne(wrapper);
        return account;
    }

//    @Override
//    public Account getAccountByName(String name) {
//        QueryWrapper wrapper = new QueryWrapper();
//        Account result = (Account) wrapper.select("userName").eq("userName", name);
//        return result;
//    }
//
//    @Override
//    public boolean isAccount(String phoneNumber, String userName, String password) {
//        try {
//            if (phoneNumber != null && userName != null && password != null) {
//                return true;
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//
//    @Override
//    public boolean checkName(String userName) {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("userName", userName);
//
//        if (accountMapper.selectOne(wrapper) == null) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void register(String phoneNumber, String userName, String password) {
//        QueryWrapper wrapper = new QueryWrapper();
//        Account account = new Account(phoneNumber, userName, password);
//        if (isAccount(account.getPhoneNumber(), account.getUserName(), account.getPassword()) && checkName(userName)) {
////        save(account);
//            accountMapper.insert(account);
//        }
//    }
//
//    @Override
//    public boolean login(String name, String pwd) {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("userName", name);
//        Account account = getOne(wrapper);
//        if (pwd.equals(accountMapper.selectOne(wrapper).getPassword())) {
//            return true;
//        } else {
//            return false;
//        }
//
//
//    }
}

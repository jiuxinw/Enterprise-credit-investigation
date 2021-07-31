package com.cn.ecig.demo.account.service;

import com.cn.ecig.demo.account.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.ecig.demo.config.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-14
 */
public interface IAccountService extends IService<Account> {

//    /**
//     * 根据用户名称获取对应的用户
//     */
//    Account getAccountByName(String name);
//    /**
//     * 判断账号密码手机号是否正确
//     */
//    boolean isAccount(String phoneNumber,String userName,String password);
//
//    /**
//     * 判断账号是否已经注册
//     */
//    boolean checkName(String userName);
//
//    /**
//     * 注册用户
//     */
//   void register(String phoneNumber,String userName,String password);
//
//    /**
//     * 登录
//     */
//    boolean login(String name,String pwd);
//    /**
//     * 登录校验密码
//     */
//    boolean checkPassword(String pwd,String md5);
    /**
     * 注册
     *      * @param user 参数封装
     *      * @return Result
     */
    Result regist(String phoneNumber, String useName, String password);

    //修改用户名
    int updateUserName(String phoneNumber, String useName);
    /**
     * 登录
     *      * @param user 用户名和密码
     *      * @return Result
     */

    Result login(String phoneNumber,String password);
    Account getAccountByPhone(String phoneNumber);
    //获取用户名
    String getUserNameByPhone(String phoneNumber);
    Account getAccountById(int id);
//    String  getNameByPhone(String phoneNumber);
}

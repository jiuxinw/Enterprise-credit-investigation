package com.cn.ecig.demo.personal.service;

import com.cn.ecig.demo.personal.entity.Personal;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-28
 */
public interface IPersonalService extends IService<Personal> {

    //获取对应用户名的url
    String getUrlByphone(String phoneNumber);
    //获取对应对应用户名的信息
    Personal getperonalByPhone(String phoneNumber);
    //增加用户
    void insertPersonByPhone(String phoneNumber);
    //修改
    Personal updateInfo(String phoneNumber,String age,String headUrl ,String address ,String email);

}

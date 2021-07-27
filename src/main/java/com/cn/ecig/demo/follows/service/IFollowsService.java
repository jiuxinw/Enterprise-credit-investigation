package com.cn.ecig.demo.follows.service;

import com.cn.ecig.demo.companyBasicInfo.entity.Co;
import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.follows.entity.Follows;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-21
 */
public interface IFollowsService extends IService<Follows> {
    //添加用户关注
    Follows insetOne(String code,String phoneNumber);

    //获取用户关注列表
    List<Follows> getComm(String phoneNumber);
    //删除用户关注
    void deleteFollows(String phoneNumber,String code);
    //获取用户关注企业
    List<Co> getBykey(String key, String phone);
    //获取对应公司的关注数
    int getCountByCOD(String code);
}

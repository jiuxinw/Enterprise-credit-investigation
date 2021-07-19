package com.cn.ecig.demo.badCompany.service;

import com.cn.ecig.demo.badCompany.entity.BadCompany;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
public interface IBadCompanyService extends IService<BadCompany> {
    //获取失信企业排名信息
    List<BadCompany> getBadRankInfoByNum(int num);

    //获取法院强制执行人信息（
    List<BadCompany> getbadManByNum(int num);
}

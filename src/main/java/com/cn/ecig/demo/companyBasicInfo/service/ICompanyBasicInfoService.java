package com.cn.ecig.demo.companyBasicInfo.service;

import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
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
public interface ICompanyBasicInfoService extends IService<CompanyBasicInfo> {
        //按关键字模糊查询企业或新闻
    List<CompanyBasicInfo> getInfoByKey(String key);

    //按企业代码查询企业
    CompanyBasicInfo getInfoByCode(String  code);
    //按标签查询企业:用户选择的标签（行业、地区、交易方式、市场分层）
    List<CompanyBasicInfo> getInfoByLabel(String industry,String area,String transferMode);
    //按区域查找

    //获取某企业基本信息
    CompanyBasicInfo getessentialInfoByCode(String code);

    //获取热搜企业信息
    List<CompanyBasicInfo> gethotEnterprise();
}

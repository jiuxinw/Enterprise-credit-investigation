package com.cn.ecig.demo.companyBasicInfo.mapper;

import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
public interface CompanyBasicInfoMapper extends BaseMapper<CompanyBasicInfo> {
    List<CompanyBasicInfo> gethotEnterprise(int num);
    List<CompanyBasicInfo> getInfoByLabel2(String[] industry,String[] area,String[] transferMode);
}

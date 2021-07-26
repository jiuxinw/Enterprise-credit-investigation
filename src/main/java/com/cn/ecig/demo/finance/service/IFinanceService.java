package com.cn.ecig.demo.finance.service;

import com.cn.ecig.demo.companyEvaluation.entity.Comp_two;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.finance.entity.Finance;
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
public interface IFinanceService extends IService<Finance> {
    //获取企业财务信息
    Finance getFinanceInfoByCode(String code);
    //获取某企业历史数据
    List<Finance> gethistoricalDataByCode(String code);
    //查询该省巨无霸
    String getBigest(String province);
    //查询领头行业
    String getBestIndustry(String province);
    //获取推荐企业排行
    List<Comp_two> getGood(String province);
    //获取总资产企业排行
    List<Comp_two>getBigAssetsList(String province);

}

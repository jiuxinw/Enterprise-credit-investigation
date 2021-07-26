package com.cn.ecig.demo.finance.mapper;

import com.cn.ecig.demo.companyEvaluation.entity.Comp_two;
import com.cn.ecig.demo.finance.entity.Finance;
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
public interface FinanceMapper extends BaseMapper<Finance> {
    String getBigest(String province);
    String getBestIndustry(String province);
    List<Comp_two> getGood(String province);
    List<Comp_two>getBigAssetsList(String province);
}

package com.cn.ecig.demo.companyEvaluation.mapper;

import com.cn.ecig.demo.companyEvaluation.entity.CompanyEvaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liguang
 * @since 2021-07-16
 */
public interface CompanyEvaluationMapper extends BaseMapper<CompanyEvaluation> {
    List<String> getGoodRankByNum(int num);
}

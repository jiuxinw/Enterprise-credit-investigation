package com.cn.ecig.demo.companyEvaluation.mapper;

import com.cn.ecig.demo.companyEvaluation.entity.Comp_four;
import com.cn.ecig.demo.companyEvaluation.entity.Comp_three;
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
    List<Comp_four> getGoodRankByNum(int num);
    List<Comp_four> getBadRankByNum(int num);
    Comp_three getBasicByCode(String code);
    List<Comp_three> getFollows(String userName);
    List<Comp_four> getGoodRankByNumArea(int num,String area);
    List<Comp_four> getGoodRankByNumInd(int num,String industry);
    List<Comp_four> getGoodRankByNumInd2(int num,String industry);
}

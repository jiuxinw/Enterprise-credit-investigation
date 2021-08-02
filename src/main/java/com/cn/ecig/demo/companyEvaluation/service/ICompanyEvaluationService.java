package com.cn.ecig.demo.companyEvaluation.service;

import com.cn.ecig.demo.companyEvaluation.entity.Comp_four;
import com.cn.ecig.demo.companyEvaluation.entity.Comp_three;
import com.cn.ecig.demo.companyEvaluation.entity.CompanyEvaluation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-16
 */
public interface ICompanyEvaluationService extends IService<CompanyEvaluation> {

    //获取某企业综合评价信息
    CompanyEvaluation getCompantEvByCode(String code);

    //获取诚信企业排名信息
    List<Comp_four> getGoodRankByNum(int num);
    List<Comp_four> getGoodRankByNumArea(int num,String area);
    List<Comp_four> getGoodRankByNumInd(int num,String industry);
    List<Comp_four> getGoodRankByNumInd2(int num,String industry);
    //通过用户名获取对应的关注列表
    List<Comp_three> getFollows(String userNumber);
    //获取关注企业简析
    Comp_three getCommnetByCode(String code);
    //
    int getFeedNumBYcode(String code);
    double getScore(String code);
    //获取失信企业排名信息
    List<Comp_four> getBadRankByNum(int num);
}

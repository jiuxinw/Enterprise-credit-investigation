package com.cn.ecig.demo.companyEvaluation.service;

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
    @Select("select * from companyEvalution left join companyBasicInfo on companyEvalution.code =companyBasicInfo.code")
    List<CompanyEvaluation> getGoodRankByNum(int num);
}

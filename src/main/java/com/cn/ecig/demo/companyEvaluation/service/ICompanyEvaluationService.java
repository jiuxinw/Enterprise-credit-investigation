package com.cn.ecig.demo.companyEvaluation.service;

import com.cn.ecig.demo.companyEvaluation.entity.CompanyEvaluation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-15
 */
public interface ICompanyEvaluationService extends IService<CompanyEvaluation> {

    //请求某企业总和评价信息
    CompanyEvaluation getCeByCode(String code);
}

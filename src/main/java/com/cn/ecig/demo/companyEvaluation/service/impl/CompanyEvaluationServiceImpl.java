package com.cn.ecig.demo.companyEvaluation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.companyEvaluation.entity.CompanyEvaluation;
import com.cn.ecig.demo.companyEvaluation.mapper.CompanyEvaluationMapper;
import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-15
 */
@Service
public class CompanyEvaluationServiceImpl extends ServiceImpl<CompanyEvaluationMapper, CompanyEvaluation> implements ICompanyEvaluationService {

    @Autowired
    private CompanyEvaluationMapper companyEvaluationMapper;
    @Override
    public CompanyEvaluation getCeByCode(String code) {
        CompanyEvaluation companyEvaluation=new CompanyEvaluation();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("code",code);
        companyEvaluation=companyEvaluationMapper.selectOne(wrapper);
        return companyEvaluation;
    }
}

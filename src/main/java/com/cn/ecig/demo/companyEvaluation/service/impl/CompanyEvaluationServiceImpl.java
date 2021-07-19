package com.cn.ecig.demo.companyEvaluation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyEvaluation.entity.CompanyEvaluation;
import com.cn.ecig.demo.companyEvaluation.mapper.CompanyEvaluationMapper;
import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.cn.ecig.demo.multipleselect.MultipleSelect;
//import com.cn.ecig.demo.multipleselect.service.MultipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-16
 */
@Service
public class CompanyEvaluationServiceImpl extends ServiceImpl<CompanyEvaluationMapper, CompanyEvaluation> implements ICompanyEvaluationService {

    @Autowired
    private  CompanyEvaluationMapper companyEvaluationMapper;
//    @Autowired
//    private MultipleService multipleService;
    @Override
    public CompanyEvaluation getCompantEvByCode(String code) {
        CompanyEvaluation companyEvaluation=new CompanyEvaluation();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("code",code);
        companyEvaluation = companyEvaluationMapper.selectOne(wrapper);
        return companyEvaluation;
    }

    @Override
    public List<CompanyEvaluation> getGoodRankByNum(int num) {
        List<CompanyEvaluation> res=new ArrayList<>();
//        MultipleSelect multipleSelect= MultipleSelect.newInstance("${companyBasicInfo}",new CompanyEvaluation(),new CompanyBasicInfo());
//        multipleSelect.where("{companyEvalution}")
//                .eq("level","excellent");
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("code").orderByDesc("score");
String sql="limit "+Integer.toString(num);
wrapper.last(sql);
res=companyEvaluationMapper.selectList(wrapper);
//      res=  multipleService.mulSelect(multipleSelect);
return  res;
    }
}

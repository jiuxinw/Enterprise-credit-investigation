package com.cn.ecig.demo.companyEvaluation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyEvaluation.entity.Comp_four;
import com.cn.ecig.demo.companyEvaluation.entity.Comp_three;
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
    public List<Comp_four> getGoodRankByNum(int num) {
//        List<String> res=new ArrayList<>();
//        List<String> res2=new ArrayList<>();
//        MultipleSelect multipleSelect= MultipleSelect.newInstance("${companyBasicInfo}",new CompanyEvaluation(),new CompanyBasicInfo());
//        multipleSelect.where("{companyEvalution}")
////                .eq("level","excellent");
//        QueryWrapper wrapper=new QueryWrapper();
//        wrapper.select("code").orderByDesc("score");
//String sql="limit "+Integer.toString(num);
//wrapper.last(sql);
//res=companyEvaluationMapper.getGoodRankByNum(num);
//        for (int i = 0; i < num; i++) {
//            res2.add(res.get(i));
//        }
        List<Comp_four> list=companyEvaluationMapper.getGoodRankByNum(num);
        return  list;
//        List<Comp_four> list2= new ArrayList<>(list.subList(0, num));
//        return  list2;
//      res=  multipleService.mulSelect(multipleSelect);
//return  res2;
    }

    @Override
    public List<Comp_four> getGoodRankByNumArea(int num, String area) {
        List<Comp_four> list=companyEvaluationMapper.getGoodRankByNumArea(num, area);
//        List<Comp_four> list2=new ArrayList<>(list.subList(0, num));
        return  list;
//        return  list2;
    }

    @Override
    public List<Comp_four> getGoodRankByNumInd(int num, String industry) {
        List<Comp_four> list=companyEvaluationMapper.getGoodRankByNumInd(num, industry);
//        List<Comp_four> list2=new ArrayList<>(list.subList(0, num));
//        return  list2;
          return  list;
    }

    @Override
    public List<Comp_three> getFollows(String userNumber) {
        return null;
    }

    @Override
    public Comp_three getCommnetByCode(String code) {
Comp_three comp_three=companyEvaluationMapper.getBasicByCode(code);
return comp_three;
    }

    @Override
    public int getFeedNumBYcode(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("feedbackNum");
        wrapper.eq("code",code);
        int res=companyEvaluationMapper.selectOne(wrapper).getFeedbackNum();
        return res;

    }

    @Override
    public double getScore(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("score");
        wrapper.eq("code",code);
        double res=companyEvaluationMapper.selectOne(wrapper).getScore();
        return res;
    }

    @Override
    public List<Comp_four> getBadRankByNum(int num) {
        List<Comp_four> list=companyEvaluationMapper.getBadRankByNum(num);
//        List<Comp_four> list2=new ArrayList<>(list.subList(0, num));
//        return  list2;
        return  list;
    }
}

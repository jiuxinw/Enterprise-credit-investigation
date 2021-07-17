package com.cn.ecig.demo.industry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.industry.entity.Industry;
import com.cn.ecig.demo.industry.mapper.IndustryMapper;
import com.cn.ecig.demo.industry.service.IIndustryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
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
 * @since 2021-07-17
 */
@Service
public class IndustryServiceImpl extends ServiceImpl<IndustryMapper, Industry> implements IIndustryService {

    @Autowired
    private IndustryMapper industryMapper;
    @Override
    public List<Industry> getByFromAndTo(String from, String to) {
        List<Industry> res=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.between("year",from,to);
        res=industryMapper.selectList(wrapper);
        return res;
    }
}

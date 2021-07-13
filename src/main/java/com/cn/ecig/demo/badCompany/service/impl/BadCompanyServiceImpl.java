package com.cn.ecig.demo.badCompany.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.badCompany.entity.BadCompany;
import com.cn.ecig.demo.badCompany.mapper.BadCompanyMapper;
import com.cn.ecig.demo.badCompany.service.IBadCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2021-07-13
 */
@Service
public class BadCompanyServiceImpl extends ServiceImpl<BadCompanyMapper, BadCompany> implements IBadCompanyService {
    @Autowired
    private BadCompanyMapper badCompanyMapper;

    @Override
    public List<BadCompany> getBadRankInfoByNum(int num) {
        List<BadCompany> result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.between("caseId",1,num);
        result=badCompanyMapper.selectList(wrapper);
        return result;
    }
}

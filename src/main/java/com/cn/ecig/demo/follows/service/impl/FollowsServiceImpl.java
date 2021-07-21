package com.cn.ecig.demo.follows.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.companyEvaluation.mapper.CompanyEvaluationMapper;
import com.cn.ecig.demo.follows.entity.Follows;
import com.cn.ecig.demo.follows.mapper.FollowsMapper;
import com.cn.ecig.demo.follows.service.IFollowsService;
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
 * @since 2021-07-21
 */
@Service
public class FollowsServiceImpl extends ServiceImpl<FollowsMapper, Follows> implements IFollowsService {
@Autowired
private FollowsMapper followsMapper;
@Autowired
private CompanyEvaluationMapper companyEvaluationMapper;
    @Override
    public Follows insetOne(String code, String userName) {
     Follows follows=new Follows(companyEvaluationMapper.getBasicByCode(code),userName);
     followsMapper.insert(follows);
     return follows;
    }

    @Override
    public List<Follows> getComm(String userName) {
        QueryWrapper wrapper=new QueryWrapper();
        List<Follows> followsList=new ArrayList<>();
        wrapper.eq("userName",userName);
        followsList=followsMapper.selectList(wrapper);
        return followsList;
    }
}

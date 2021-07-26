package com.cn.ecig.demo.follows.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.companyBasicInfo.entity.Co;
import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyBasicInfo.mapper.CompanyBasicInfoMapper;
import com.cn.ecig.demo.companyEvaluation.mapper.CompanyEvaluationMapper;
import com.cn.ecig.demo.follows.entity.Follows;
import com.cn.ecig.demo.follows.mapper.FollowsMapper;
import com.cn.ecig.demo.follows.service.IFollowsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Follows insetOne(String code, String phoneNumber) {
     Follows follows=new Follows(companyEvaluationMapper.getBasicByCode(code),phoneNumber);
     followsMapper.insert(follows);
     return follows;
    }

    @Override
    public List<Follows> getComm(String phoneNumber) {
        QueryWrapper wrapper=new QueryWrapper();
        List<Follows> followsList=new ArrayList<>();
        wrapper.eq("phoneNumber",phoneNumber);
        followsList=followsMapper.selectList(wrapper);
        return followsList;
    }

    @Override
    public void deleteFollows(String phoneNumber, String code) {
        Map<String,Object> map=new HashMap<>();
        map.put("phoneNumber",phoneNumber);
      map.put("code",code);
      followsMapper.deleteByMap(map);
    }

    @Override
    public List<Co> getBykey(String key, String phone) {
//        List<CompanyBasicInfo>  list=
        return  followsMapper.getBykey(key, phone)
                ;
    }
}

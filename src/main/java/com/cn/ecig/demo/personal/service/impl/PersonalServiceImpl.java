package com.cn.ecig.demo.personal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cn.ecig.demo.personal.entity.Personal;
import com.cn.ecig.demo.personal.mapper.PersonalMapper;
import com.cn.ecig.demo.personal.service.IPersonalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-28
 */
@Service
public class PersonalServiceImpl extends ServiceImpl<PersonalMapper, Personal> implements IPersonalService {
@Autowired
private PersonalMapper personalMapper;
@Autowired
private IPersonalService personalService;

    @Override
    public String getUrlByphone(String phoneNumber) {
        try {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("phoneNumber", phoneNumber);
            String res = personalMapper.selectOne(wrapper).getHeadUrl();
            return res;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Personal getperonalByPhone(String phoneNumber) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("phoneNumber",phoneNumber);
        Personal personal=personalMapper.selectOne(wrapper);
        return personal;
    }

    @Override
    public void insertPersonByPhone(String phoneNumber) {
        if(personalService.getperonalByPhone(phoneNumber)==null){
            personalMapper.insert(new Personal(phoneNumber));
        }
    }

    @Override
    public Personal updateInfo(String phoneNumber, String age, String headUrl, String address, String email) {
        Personal personal=new Personal();
        personal.setAddress(address);
        personal.setAge(age);
        personal.setEmail(email);
        personal.setHeadUrl(headUrl);
        UpdateWrapper wrapper=new UpdateWrapper();
        wrapper.eq("phoneNumber" ,phoneNumber);
personalMapper.update(personal,wrapper);
        return personal;

    }
}

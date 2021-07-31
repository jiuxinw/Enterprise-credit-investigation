package com.cn.ecig.demo.announcmenetInfo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.announcmenetInfo.entity.AnnouncmenetInfo;
import com.cn.ecig.demo.announcmenetInfo.mapper.AnnouncmenetInfoMapper;
import com.cn.ecig.demo.announcmenetInfo.service.IAnnouncmenetInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
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
 * @since 2021-07-14
 */
@Service
public class AnnouncmenetInfoServiceImpl extends ServiceImpl<AnnouncmenetInfoMapper, AnnouncmenetInfo> implements IAnnouncmenetInfoService {
    @Autowired
    private AnnouncmenetInfoMapper announcmenetInfoMapper;

    @Override
    public List<AnnouncmenetInfo> getAnnounceByCode(String code) {
        List<AnnouncmenetInfo> result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("code",code);
        result=announcmenetInfoMapper.selectList(wrapper);
        return result;
    }

    @Override
    public List<AnnouncmenetInfo> getANNounceBycODEaN(String code, String from, String to) {
        List<AnnouncmenetInfo>list=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("code",code);
        wrapper.between("idate",from,to);
        list=announcmenetInfoMapper.selectList(wrapper);
        return list;
    }
}

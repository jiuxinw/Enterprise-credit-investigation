package com.cn.ecig.demo.companyBasicInfo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.cn.ecig.demo.companyBasicInfo.mapper.CompanyBasicInfoMapper;
import com.cn.ecig.demo.companyBasicInfo.service.ICompanyBasicInfoService;
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
public class CompanyBasicInfoServiceImpl extends ServiceImpl<CompanyBasicInfoMapper, CompanyBasicInfo> implements ICompanyBasicInfoService {

    @Autowired
     private  CompanyBasicInfoMapper companyBasicInfoMapper;
    @Override
    public List<CompanyBasicInfo> getInfoByKey(String key) {
        List<CompanyBasicInfo> result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.like("name",key);
        result= companyBasicInfoMapper.selectList(wrapper);
        return result;

    }

    @Override
    public CompanyBasicInfo getInfoByCode(String code) {
       CompanyBasicInfo companyBasicInfo=new CompanyBasicInfo();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("code",code);
        companyBasicInfo=companyBasicInfoMapper.selectOne(wrapper);
        return  companyBasicInfo;
    }

    @Override
    public List<CompanyBasicInfo> getInfoByLabel(String industry, String area, String transferMode) {
        List<CompanyBasicInfo>result=new ArrayList<>();
        QueryWrapper<CompanyBasicInfo> queryWrapper =new QueryWrapper();
        queryWrapper.and(
                Wrapper->
                        Wrapper.like("industry",industry)
                                .or()
                .like("area",area).or().like("transferMode",transferMode));

result=companyBasicInfoMapper.selectList(queryWrapper);
return result;
    }

    @Override
    public List<CompanyBasicInfo> getInfoByLabel2(String[] industry, String[] area, String[] transferMode) {
        List<CompanyBasicInfo> res = new ArrayList<>();
        QueryWrapper<CompanyBasicInfo> queryWrapper = new QueryWrapper<>();
//        int len_in = industry.length;
//        int len_area = area.length;
//        int len_tra = transferMode.length;
        for (String i:industry) {
            for (String a:area) {
                for (String t:transferMode) {
//                    queryWrapper.and(
//                            Wrapper ->
//                                    Wrapper.like("industry", i)
//                                            .or()
//                                            .like("area", a)
//                                            .or().
//                                            like("transferMode", t));
//                }
                    queryWrapper.or(
                            Wrapper ->
                                    Wrapper.like("industry", i)
//                                            .and()
                                            .like("area", a).
//                                            .and().
                                            like("transferMode", t));
                }
            }
        }
        queryWrapper.last("limit 100");
        res=companyBasicInfoMapper.selectList(queryWrapper);
        return res;
//        return companyBasicInfoMapper.getInfoByLabel2(industry, area, transferMode);
//        return companyBasicInfoMapper.getInfoByLabel2(industry);
    }

    @Override
    public String getRegionByCode(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("area");
        wrapper.eq("code",code);
        String res=companyBasicInfoMapper.selectOne(wrapper).getArea();
        return res;
    }


    @Override
    public CompanyBasicInfo getessentialInfoByCode(String code) {
        CompanyBasicInfo companyBasicInfo=new CompanyBasicInfo();
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("code",code);
        companyBasicInfo=companyBasicInfoMapper.selectOne(queryWrapper);
        return companyBasicInfo;
    }

    @Override
    public List<CompanyBasicInfo> getListByArea(String region) {
        List<CompanyBasicInfo> result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.like("industry",region);
        wrapper.last("limit 10");
        result= companyBasicInfoMapper.selectList(wrapper);
        return result;
    }

    @Override
    public String getNameByCODE(String code) {
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("code",code);
        String res=companyBasicInfoMapper.selectOne(queryWrapper).getName();
        return res;
    }

    @Override
    public List<CompanyBasicInfo> gethotEnterprise(int num) {
        List<CompanyBasicInfo> companyBasicInfoList=new ArrayList<>();
     companyBasicInfoList=companyBasicInfoMapper.gethotEnterprise(num);
        return  companyBasicInfoList;
    }

    @Override
    public int getNumByProvince(String province) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.like("area",province);
        int res=companyBasicInfoMapper.selectCount(wrapper);
        return res;
    }

}

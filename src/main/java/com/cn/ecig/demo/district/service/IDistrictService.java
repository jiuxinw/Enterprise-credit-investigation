package com.cn.ecig.demo.district.service;

import com.cn.ecig.demo.district.entity.District;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-17
 */
public interface IDistrictService extends IService<District> {

    //获取地区平均资产情况信息
    List<District> getRegionAssets();
}

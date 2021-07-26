package com.cn.ecig.demo.follows.mapper;

import com.cn.ecig.demo.companyBasicInfo.entity.Co;
import com.cn.ecig.demo.companyBasicInfo.entity.Company;
import com.cn.ecig.demo.follows.entity.Follows;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liguang
 * @since 2021-07-21
 */
public interface FollowsMapper extends BaseMapper<Follows> {
    //获取用户关注企业
    List<Co> getBykey(String key, String phone);
}

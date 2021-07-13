package com.cn.ecig.demo.executives.service;

import com.cn.ecig.demo.executives.entity.Executives;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
public interface IExecutivesService extends IService<Executives> {
    //获取企业高管信息
    List<Executives> queryExecLsitByCode(String code);
}

package com.cn.ecig.demo.top100Company.service;

import com.cn.ecig.demo.top100Company.entity.Top100Company;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-24
 */
public interface ITop100CompanyService extends IService<Top100Company> {
 //获取对应省份的前一百数量
    int getNumByProvince(String province);
}

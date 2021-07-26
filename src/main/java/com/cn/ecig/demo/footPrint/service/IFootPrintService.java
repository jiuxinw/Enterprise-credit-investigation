package com.cn.ecig.demo.footPrint.service;

import com.cn.ecig.demo.footPrint.entity.FootPrint;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-23
 */
public interface IFootPrintService extends IService<FootPrint> {

   List<FootPrint> getFootPrint(String name);
}

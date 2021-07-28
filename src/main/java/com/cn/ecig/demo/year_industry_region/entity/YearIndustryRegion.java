package com.cn.ecig.demo.year_industry_region.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liguang
 * @since 2021-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class YearIndustryRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String year;

    private String industry;

    private String 北京市;

    private String 天津市;

    private String 河北省;

    private String 山西省;

    private String 内蒙古自治区;

    private String 辽宁省;

    private String 吉林省;

    private String 黑龙江省;

    private String 上海市;

    private String 江苏省;

    private String 浙江省;

    private String 安徽省;

    private String 福建省;

    private String 江西省;

    private String 山东省;

    private String 河南省;

    private String 湖北省;

    private String 湖南省;

    private String 广东省;

    private String 广西壮族自治区;

    private String 海南省;

    private String 重庆市;

    private String 四川省;

    private String 贵州省;

    private String 云南省;

    private String 西藏自治区;

    private String 陕西省;

    private String 甘肃省;

    private String 青海省;

    private String 宁夏回族自治区;

    private String 新疆维吾尔自治区;


    public YearIndustryRegion() {
    }
}

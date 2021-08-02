/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: I2
 * Author:   liyou
 * Date:     2021/8/2 9:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2021/8/2
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2021/8/2
 * @since 1.0.0
 */
package com.cn.ecig.demo.industry_listingDate_rank.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class I2 {
    @TableField("companyCode")
    private String companyCode;

    @TableField("companyName")
    private String companyName;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

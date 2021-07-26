/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Co
 * Author:   liyou
 * Date:     2021/7/26 16:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/26
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/26
 * @since 1.0.0
 */
package com.cn.ecig.demo.companyBasicInfo.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class Co {
    private String name;
    private String code;
    /**
     * 法人代表
     */
    @TableField("legalRepresentative")
    private String legalRepresentative;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

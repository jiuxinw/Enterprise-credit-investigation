/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Comp_two
 * Author:   liyou
 * Date:     2021/7/24 15:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/24
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/24
 * @since 1.0.0
 */
package com.cn.ecig.demo.companyEvaluation.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Comp_two {
    @TableId("code")
    private String code;
    @TableId("name")
    private String name;

    public Comp_two(){
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

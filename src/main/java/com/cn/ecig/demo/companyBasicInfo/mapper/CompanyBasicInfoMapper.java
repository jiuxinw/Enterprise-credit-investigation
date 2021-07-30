package com.cn.ecig.demo.companyBasicInfo.mapper;

import com.cn.ecig.demo.companyBasicInfo.entity.CompanyBasicInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
public interface CompanyBasicInfoMapper extends BaseMapper<CompanyBasicInfo> {
    List<CompanyBasicInfo> gethotEnterprise(int num);
//    List<CompanyBasicInfo> getInfoByLabel2(@Param("industry")List<String> industry
////                                       ,    @Param("area")List<String>area,
////                                           @Param("transferMode") List<String>transferMode
//    );
//    @Select({"<script>"+
//              "select *" +
//                "from companyBasicInfo"+
//    "where industry in #{industry} and area in #{area} and transferMode in #{transferMode}"})
//    List<CompanyBasicInfo> getInfoByLabel2(@Param("industry")String[] industry,
//                                           @Param("area") String[] area,
//                                           @Param("transferMode")  String[] transferMode);
}

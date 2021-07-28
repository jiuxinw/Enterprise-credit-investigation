package com.cn.ecig.demo.year2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getBeiJing() {
        return BeiJing;
    }

    public void setBeiJing(String beiJing) {
        BeiJing = beiJing;
    }

    public String getTianJin() {
        return TianJin;
    }

    public void setTianJin(String tianJin) {
        TianJin = tianJin;
    }

    public String getHeBei() {
        return HeBei;
    }

    public void setHeBei(String heBei) {
        HeBei = heBei;
    }

    public String getShanXi() {
        return ShanXi;
    }

    public void setShanXi(String shanXi) {
        ShanXi = shanXi;
    }

    public String getNeiMengGu() {
        return NeiMengGu;
    }

    public void setNeiMengGu(String neiMengGu) {
        NeiMengGu = neiMengGu;
    }

    public String getLiaoNing() {
        return LiaoNing;
    }

    public void setLiaoNing(String liaoNing) {
        LiaoNing = liaoNing;
    }

    public String getJiLin() {
        return JiLin;
    }

    public void setJiLin(String jiLin) {
        JiLin = jiLin;
    }

    public String getHeiLongJiang() {
        return HeiLongJiang;
    }

    public void setHeiLongJiang(String heiLongJiang) {
        HeiLongJiang = heiLongJiang;
    }

    public String getShangHai() {
        return ShangHai;
    }

    public void setShangHai(String shangHai) {
        ShangHai = shangHai;
    }

    public String getJiangSu() {
        return JiangSu;
    }

    public void setJiangSu(String jiangSu) {
        JiangSu = jiangSu;
    }

    public String getZheJiang() {
        return ZheJiang;
    }

    public void setZheJiang(String zheJiang) {
        ZheJiang = zheJiang;
    }

    public String getAnHui() {
        return AnHui;
    }

    public void setAnHui(String anHui) {
        AnHui = anHui;
    }

    public String getFuJian() {
        return FuJian;
    }

    public void setFuJian(String fuJian) {
        FuJian = fuJian;
    }

    public String getJiangXi() {
        return JiangXi;
    }

    public void setJiangXi(String jiangXi) {
        JiangXi = jiangXi;
    }

    public String getShanDong() {
        return ShanDong;
    }

    public void setShanDong(String shanDong) {
        ShanDong = shanDong;
    }

    public String getHeNan() {
        return HeNan;
    }

    public void setHeNan(String heNan) {
        HeNan = heNan;
    }

    public String getHuBei() {
        return HuBei;
    }

    public void setHuBei(String huBei) {
        HuBei = huBei;
    }

    public String getHuNan() {
        return HuNan;
    }

    public void setHuNan(String huNan) {
        HuNan = huNan;
    }

    public String getGuangDong() {
        return GuangDong;
    }

    public void setGuangDong(String guangDong) {
        GuangDong = guangDong;
    }

    public String getGuangXi() {
        return GuangXi;
    }

    public void setGuangXi(String guangXi) {
        GuangXi = guangXi;
    }

    public String getHaiNan() {
        return HaiNan;
    }

    public void setHaiNan(String haiNan) {
        HaiNan = haiNan;
    }

    public String getChongQing() {
        return ChongQing;
    }

    public void setChongQing(String chongQing) {
        ChongQing = chongQing;
    }

    public String getSiChuan() {
        return SiChuan;
    }

    public void setSiChuan(String siChuan) {
        SiChuan = siChuan;
    }

    public String getGuiZhou() {
        return GuiZhou;
    }

    public void setGuiZhou(String guiZhou) {
        GuiZhou = guiZhou;
    }

    public String getYunNan() {
        return YunNan;
    }

    public void setYunNan(String yunNan) {
        YunNan = yunNan;
    }

    public String getXiZang() {
        return XiZang;
    }

    public void setXiZang(String xiZang) {
        XiZang = xiZang;
    }

    public String getSanXi() {
        return SanXi;
    }

    public void setSanXi(String sanXi) {
        SanXi = sanXi;
    }

    public String getGanSu() {
        return GanSu;
    }

    public void setGanSu(String ganSu) {
        GanSu = ganSu;
    }

    public String getQingHai() {
        return QingHai;
    }

    public void setQingHai(String qingHai) {
        QingHai = qingHai;
    }

    public String getNingXia() {
        return NingXia;
    }

    public void setNingXia(String ningXia) {
        NingXia = ningXia;
    }

    public String getXinJiang() {
        return XinJiang;
    }

    public void setXinJiang(String xinJiang) {
        XinJiang = xinJiang;
    }

    private String id;

    private String year;

    private String industry;

    @TableField("BeiJing")
    private String BeiJing;

    @TableField("TianJin")
    private String TianJin;

    @TableField("HeBei")
    private String HeBei;

    @TableField("ShanXi")
    private String ShanXi;

    @TableField("NeiMengGu")
    private String NeiMengGu;

    @TableField("LiaoNing")
    private String LiaoNing;

    @TableField("JiLin")
    private String JiLin;

    @TableField("HeiLongJiang")
    private String HeiLongJiang;

    @TableField("ShangHai")
    private String ShangHai;

    @TableField("JiangSu")
    private String JiangSu;

    @TableField("ZheJiang")
    private String ZheJiang;

    @TableField("AnHui")
    private String AnHui;

    @TableField("FuJian")
    private String FuJian;

    @TableField("JiangXi")
    private String JiangXi;

    @TableField("ShanDong")
    private String ShanDong;

    @TableField("HeNan")
    private String HeNan;

    @TableField("HuBei")
    private String HuBei;

    @TableField("HuNan")
    private String HuNan;

    @TableField("GuangDong")
    private String GuangDong;

    @TableField("GuangXi")
    private String GuangXi;

    @TableField("HaiNan")
    private String HaiNan;

    @TableField("ChongQing")
    private String ChongQing;

    @TableField("SiChuan")
    private String SiChuan;

    @TableField("GuiZhou")
    private String GuiZhou;

    @TableField("YunNan")
    private String YunNan;

    @TableField("XiZang")
    private String XiZang;

    @TableField("SanXi")
    private String SanXi;

    @TableField("GanSu")
    private String GanSu;

    @TableField("QingHai")
    private String QingHai;

    @TableField("NingXia")
    private String NingXia;

    @TableField("XinJiang")
    private String XinJiang;


}

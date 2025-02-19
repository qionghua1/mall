package com.example.mall.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品属性对象 pms_attr
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
public class Attr extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 属性id */
    private Long attrId;

    /** 属性名 */
    @Excel(name = "属性名")
    private String attrName;

    /** 是否需要检索[0-不需要，1-需要] */
    @Excel(name = "是否需要检索[0-不需要，1-需要]")
    private Long searchType;

    /** 属性图标 */
    @Excel(name = "属性图标")
    private String icon;

    /** 可选值列表[用逗号分隔] */
    @Excel(name = "可选值列表[用逗号分隔]")
    private String valueSelect;

    /** 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性] */
    @Excel(name = "属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]")
    private Long attrType;

    /** 启用状态[0 - 禁用，1 - 启用] */
    @Excel(name = "启用状态[0 - 禁用，1 - 启用]")
    private Long enable;

    /** 所属分类 */
    @Excel(name = "所属分类")
    private Long catelogId;

    /** 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整 */
    @Excel(name = "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Long showDesc;

    public void setAttrId(Long attrId) 
    {
        this.attrId = attrId;
    }

    public Long getAttrId() 
    {
        return attrId;
    }
    public void setAttrName(String attrName) 
    {
        this.attrName = attrName;
    }

    public String getAttrName() 
    {
        return attrName;
    }
    public void setSearchType(Long searchType) 
    {
        this.searchType = searchType;
    }

    public Long getSearchType() 
    {
        return searchType;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setValueSelect(String valueSelect) 
    {
        this.valueSelect = valueSelect;
    }

    public String getValueSelect() 
    {
        return valueSelect;
    }
    public void setAttrType(Long attrType) 
    {
        this.attrType = attrType;
    }

    public Long getAttrType() 
    {
        return attrType;
    }
    public void setEnable(Long enable) 
    {
        this.enable = enable;
    }

    public Long getEnable() 
    {
        return enable;
    }
    public void setCatelogId(Long catelogId) 
    {
        this.catelogId = catelogId;
    }

    public Long getCatelogId() 
    {
        return catelogId;
    }
    public void setShowDesc(Long showDesc) 
    {
        this.showDesc = showDesc;
    }

    public Long getShowDesc() 
    {
        return showDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attrId", getAttrId())
            .append("attrName", getAttrName())
            .append("searchType", getSearchType())
            .append("icon", getIcon())
            .append("valueSelect", getValueSelect())
            .append("attrType", getAttrType())
            .append("enable", getEnable())
            .append("catelogId", getCatelogId())
            .append("showDesc", getShowDesc())
            .toString();
    }
}

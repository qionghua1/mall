package com.example.mall.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * sku销售属性&值对象 pms_sku_sale_attr_value
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
public class SkuSaleAttrValue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** sku_id */
    @Excel(name = "sku_id")
    private Long skuId;

    /** attr_id */
    @Excel(name = "attr_id")
    private Long attrId;

    /** 销售属性名 */
    @Excel(name = "销售属性名")
    private String attrName;

    /** 销售属性值 */
    @Excel(name = "销售属性值")
    private String attrValue;

    /** 顺序 */
    @Excel(name = "顺序")
    private Long attrSort;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSkuId(Long skuId) 
    {
        this.skuId = skuId;
    }

    public Long getSkuId() 
    {
        return skuId;
    }
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
    public void setAttrValue(String attrValue) 
    {
        this.attrValue = attrValue;
    }

    public String getAttrValue() 
    {
        return attrValue;
    }
    public void setAttrSort(Long attrSort) 
    {
        this.attrSort = attrSort;
    }

    public Long getAttrSort() 
    {
        return attrSort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("skuId", getSkuId())
            .append("attrId", getAttrId())
            .append("attrName", getAttrName())
            .append("attrValue", getAttrValue())
            .append("attrSort", getAttrSort())
            .toString();
    }
}

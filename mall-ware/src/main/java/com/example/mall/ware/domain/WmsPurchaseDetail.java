package com.example.mall.ware.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购信息细节对象 wms_purchase_detail
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public class WmsPurchaseDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 采购单id */
    @Excel(name = "采购单id")
    private Long purchaseId;

    /** 采购商品id */
    @Excel(name = "采购商品id")
    private Long skuId;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long skuNum;

    /** 采购金额 */
    @Excel(name = "采购金额")
    private BigDecimal skuPrice;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long wareId;

    /** 状态[0新建，1已分配，2正在采购，3已完成，4采购失败] */
    @Excel(name = "状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPurchaseId(Long purchaseId) 
    {
        this.purchaseId = purchaseId;
    }

    public Long getPurchaseId() 
    {
        return purchaseId;
    }
    public void setSkuId(Long skuId) 
    {
        this.skuId = skuId;
    }

    public Long getSkuId() 
    {
        return skuId;
    }
    public void setSkuNum(Long skuNum) 
    {
        this.skuNum = skuNum;
    }

    public Long getSkuNum() 
    {
        return skuNum;
    }
    public void setSkuPrice(BigDecimal skuPrice) 
    {
        this.skuPrice = skuPrice;
    }

    public BigDecimal getSkuPrice() 
    {
        return skuPrice;
    }
    public void setWareId(Long wareId) 
    {
        this.wareId = wareId;
    }

    public Long getWareId() 
    {
        return wareId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseId", getPurchaseId())
            .append("skuId", getSkuId())
            .append("skuNum", getSkuNum())
            .append("skuPrice", getSkuPrice())
            .append("wareId", getWareId())
            .append("status", getStatus())
            .toString();
    }
}

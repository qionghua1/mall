package com.example.mall.coupon.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 秒杀商品通知订阅对象 sms_seckill_sku_notice
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public class SmsSeckillSkuNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** member_id */
    @Excel(name = "member_id")
    private Long memberId;

    /** sku_id */
    @Excel(name = "sku_id")
    private Long skuId;

    /** 活动场次id */
    @Excel(name = "活动场次id")
    private Long sessionId;

    /** 订阅时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订阅时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date subcribeTime;

    /** 发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    /** 通知方式[0-短信，1-邮件] */
    @Excel(name = "通知方式[0-短信，1-邮件]")
    private Integer noticeType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setSkuId(Long skuId) 
    {
        this.skuId = skuId;
    }

    public Long getSkuId() 
    {
        return skuId;
    }
    public void setSessionId(Long sessionId) 
    {
        this.sessionId = sessionId;
    }

    public Long getSessionId() 
    {
        return sessionId;
    }
    public void setSubcribeTime(Date subcribeTime) 
    {
        this.subcribeTime = subcribeTime;
    }

    public Date getSubcribeTime() 
    {
        return subcribeTime;
    }
    public void setSendTime(Date sendTime) 
    {
        this.sendTime = sendTime;
    }

    public Date getSendTime() 
    {
        return sendTime;
    }
    public void setNoticeType(Integer noticeType) 
    {
        this.noticeType = noticeType;
    }

    public Integer getNoticeType() 
    {
        return noticeType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("memberId", getMemberId())
            .append("skuId", getSkuId())
            .append("sessionId", getSessionId())
            .append("subcribeTime", getSubcribeTime())
            .append("sendTime", getSendTime())
            .append("noticeType", getNoticeType())
            .toString();
    }
}

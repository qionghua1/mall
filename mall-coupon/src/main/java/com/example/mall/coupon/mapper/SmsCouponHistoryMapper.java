package com.example.mall.coupon.mapper;

import java.util.List;
import com.example.mall.coupon.domain.SmsCouponHistory;

/**
 * 优惠券领取历史记录Mapper接口
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
public interface SmsCouponHistoryMapper 
{
    /**
     * 查询优惠券领取历史记录
     * 
     * @param id 优惠券领取历史记录主键
     * @return 优惠券领取历史记录
     */
    public SmsCouponHistory selectSmsCouponHistoryById(Long id);

    /**
     * 查询优惠券领取历史记录列表
     * 
     * @param smsCouponHistory 优惠券领取历史记录
     * @return 优惠券领取历史记录集合
     */
    public List<SmsCouponHistory> selectSmsCouponHistoryList(SmsCouponHistory smsCouponHistory);

    /**
     * 新增优惠券领取历史记录
     * 
     * @param smsCouponHistory 优惠券领取历史记录
     * @return 结果
     */
    public int insertSmsCouponHistory(SmsCouponHistory smsCouponHistory);

    /**
     * 修改优惠券领取历史记录
     * 
     * @param smsCouponHistory 优惠券领取历史记录
     * @return 结果
     */
    public int updateSmsCouponHistory(SmsCouponHistory smsCouponHistory);

    /**
     * 删除优惠券领取历史记录
     * 
     * @param id 优惠券领取历史记录主键
     * @return 结果
     */
    public int deleteSmsCouponHistoryById(Long id);

    /**
     * 批量删除优惠券领取历史记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSmsCouponHistoryByIds(Long[] ids);
}

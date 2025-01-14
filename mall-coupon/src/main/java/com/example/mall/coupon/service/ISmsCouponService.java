package com.example.mall.coupon.service;

import java.util.List;
import com.example.mall.coupon.domain.SmsCoupon;

/**
 * 优惠券信息Service接口
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
public interface ISmsCouponService 
{
    /**
     * 查询优惠券信息
     * 
     * @param id 优惠券信息主键
     * @return 优惠券信息
     */
    public SmsCoupon selectSmsCouponById(Long id);

    /**
     * 查询优惠券信息列表
     * 
     * @param smsCoupon 优惠券信息
     * @return 优惠券信息集合
     */
    public List<SmsCoupon> selectSmsCouponList(SmsCoupon smsCoupon);

    /**
     * 新增优惠券信息
     * 
     * @param smsCoupon 优惠券信息
     * @return 结果
     */
    public int insertSmsCoupon(SmsCoupon smsCoupon);

    /**
     * 修改优惠券信息
     * 
     * @param smsCoupon 优惠券信息
     * @return 结果
     */
    public int updateSmsCoupon(SmsCoupon smsCoupon);

    /**
     * 批量删除优惠券信息
     * 
     * @param ids 需要删除的优惠券信息主键集合
     * @return 结果
     */
    public int deleteSmsCouponByIds(Long[] ids);

    /**
     * 删除优惠券信息信息
     * 
     * @param id 优惠券信息主键
     * @return 结果
     */
    public int deleteSmsCouponById(Long id);
}

package com.example.mall.coupon.mapper;

import java.util.List;
import com.example.mall.coupon.domain.SmsCouponSpuCategoryRelation;

/**
 * 优惠券分类关联Mapper接口
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
public interface SmsCouponSpuCategoryRelationMapper 
{
    /**
     * 查询优惠券分类关联
     * 
     * @param id 优惠券分类关联主键
     * @return 优惠券分类关联
     */
    public SmsCouponSpuCategoryRelation selectSmsCouponSpuCategoryRelationById(Long id);

    /**
     * 查询优惠券分类关联列表
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联集合
     */
    public List<SmsCouponSpuCategoryRelation> selectSmsCouponSpuCategoryRelationList(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /**
     * 新增优惠券分类关联
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    public int insertSmsCouponSpuCategoryRelation(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /**
     * 修改优惠券分类关联
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    public int updateSmsCouponSpuCategoryRelation(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /**
     * 删除优惠券分类关联
     * 
     * @param id 优惠券分类关联主键
     * @return 结果
     */
    public int deleteSmsCouponSpuCategoryRelationById(Long id);

    /**
     * 批量删除优惠券分类关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSmsCouponSpuCategoryRelationByIds(Long[] ids);
}

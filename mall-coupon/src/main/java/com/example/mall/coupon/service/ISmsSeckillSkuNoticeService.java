package com.example.mall.coupon.service;

import java.util.List;
import com.example.mall.coupon.domain.SmsSeckillSkuNotice;

/**
 * 秒杀商品通知订阅Service接口
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public interface ISmsSeckillSkuNoticeService 
{
    /**
     * 查询秒杀商品通知订阅
     * 
     * @param id 秒杀商品通知订阅主键
     * @return 秒杀商品通知订阅
     */
    public SmsSeckillSkuNotice selectSmsSeckillSkuNoticeById(Long id);

    /**
     * 查询秒杀商品通知订阅列表
     * 
     * @param smsSeckillSkuNotice 秒杀商品通知订阅
     * @return 秒杀商品通知订阅集合
     */
    public List<SmsSeckillSkuNotice> selectSmsSeckillSkuNoticeList(SmsSeckillSkuNotice smsSeckillSkuNotice);

    /**
     * 新增秒杀商品通知订阅
     * 
     * @param smsSeckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    public int insertSmsSeckillSkuNotice(SmsSeckillSkuNotice smsSeckillSkuNotice);

    /**
     * 修改秒杀商品通知订阅
     * 
     * @param smsSeckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    public int updateSmsSeckillSkuNotice(SmsSeckillSkuNotice smsSeckillSkuNotice);

    /**
     * 批量删除秒杀商品通知订阅
     * 
     * @param ids 需要删除的秒杀商品通知订阅主键集合
     * @return 结果
     */
    public int deleteSmsSeckillSkuNoticeByIds(Long[] ids);

    /**
     * 删除秒杀商品通知订阅信息
     * 
     * @param id 秒杀商品通知订阅主键
     * @return 结果
     */
    public int deleteSmsSeckillSkuNoticeById(Long id);
}

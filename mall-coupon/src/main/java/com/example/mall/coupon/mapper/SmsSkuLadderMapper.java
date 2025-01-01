package com.example.mall.coupon.mapper;

import java.util.List;
import com.example.mall.coupon.domain.SmsSkuLadder;

/**
 * 商品阶梯价格Mapper接口
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public interface SmsSkuLadderMapper 
{
    /**
     * 查询商品阶梯价格
     * 
     * @param id 商品阶梯价格主键
     * @return 商品阶梯价格
     */
    public SmsSkuLadder selectSmsSkuLadderById(Long id);

    /**
     * 查询商品阶梯价格列表
     * 
     * @param smsSkuLadder 商品阶梯价格
     * @return 商品阶梯价格集合
     */
    public List<SmsSkuLadder> selectSmsSkuLadderList(SmsSkuLadder smsSkuLadder);

    /**
     * 新增商品阶梯价格
     * 
     * @param smsSkuLadder 商品阶梯价格
     * @return 结果
     */
    public int insertSmsSkuLadder(SmsSkuLadder smsSkuLadder);

    /**
     * 修改商品阶梯价格
     * 
     * @param smsSkuLadder 商品阶梯价格
     * @return 结果
     */
    public int updateSmsSkuLadder(SmsSkuLadder smsSkuLadder);

    /**
     * 删除商品阶梯价格
     * 
     * @param id 商品阶梯价格主键
     * @return 结果
     */
    public int deleteSmsSkuLadderById(Long id);

    /**
     * 批量删除商品阶梯价格
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSmsSkuLadderByIds(Long[] ids);
}

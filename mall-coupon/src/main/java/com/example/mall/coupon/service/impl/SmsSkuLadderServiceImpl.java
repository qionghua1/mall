package com.example.mall.coupon.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mall.coupon.mapper.SmsSkuLadderMapper;
import com.example.mall.coupon.domain.SmsSkuLadder;
import com.example.mall.coupon.service.ISmsSkuLadderService;

/**
 * 商品阶梯价格Service业务层处理
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@Service
public class SmsSkuLadderServiceImpl implements ISmsSkuLadderService 
{
    @Autowired
    private SmsSkuLadderMapper smsSkuLadderMapper;

    /**
     * 查询商品阶梯价格
     * 
     * @param id 商品阶梯价格主键
     * @return 商品阶梯价格
     */
    @Override
    public SmsSkuLadder selectSmsSkuLadderById(Long id)
    {
        return smsSkuLadderMapper.selectSmsSkuLadderById(id);
    }

    /**
     * 查询商品阶梯价格列表
     * 
     * @param smsSkuLadder 商品阶梯价格
     * @return 商品阶梯价格
     */
    @Override
    public List<SmsSkuLadder> selectSmsSkuLadderList(SmsSkuLadder smsSkuLadder)
    {
        return smsSkuLadderMapper.selectSmsSkuLadderList(smsSkuLadder);
    }

    /**
     * 新增商品阶梯价格
     * 
     * @param smsSkuLadder 商品阶梯价格
     * @return 结果
     */
    @Override
    public int insertSmsSkuLadder(SmsSkuLadder smsSkuLadder)
    {
        return smsSkuLadderMapper.insertSmsSkuLadder(smsSkuLadder);
    }

    /**
     * 修改商品阶梯价格
     * 
     * @param smsSkuLadder 商品阶梯价格
     * @return 结果
     */
    @Override
    public int updateSmsSkuLadder(SmsSkuLadder smsSkuLadder)
    {
        return smsSkuLadderMapper.updateSmsSkuLadder(smsSkuLadder);
    }

    /**
     * 批量删除商品阶梯价格
     * 
     * @param ids 需要删除的商品阶梯价格主键
     * @return 结果
     */
    @Override
    public int deleteSmsSkuLadderByIds(Long[] ids)
    {
        return smsSkuLadderMapper.deleteSmsSkuLadderByIds(ids);
    }

    /**
     * 删除商品阶梯价格信息
     * 
     * @param id 商品阶梯价格主键
     * @return 结果
     */
    @Override
    public int deleteSmsSkuLadderById(Long id)
    {
        return smsSkuLadderMapper.deleteSmsSkuLadderById(id);
    }
}

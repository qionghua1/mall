package com.example.mall.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mall.order.mapper.OmsOrderSettingMapper;
import com.example.mall.order.domain.OmsOrderSetting;
import com.example.mall.order.service.IOmsOrderSettingService;

/**
 * 订单配置信息Service业务层处理
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@Service
public class OmsOrderSettingServiceImpl implements IOmsOrderSettingService 
{
    @Autowired
    private OmsOrderSettingMapper omsOrderSettingMapper;

    /**
     * 查询订单配置信息
     * 
     * @param id 订单配置信息主键
     * @return 订单配置信息
     */
    @Override
    public OmsOrderSetting selectOmsOrderSettingById(Long id)
    {
        return omsOrderSettingMapper.selectOmsOrderSettingById(id);
    }

    /**
     * 查询订单配置信息列表
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 订单配置信息
     */
    @Override
    public List<OmsOrderSetting> selectOmsOrderSettingList(OmsOrderSetting omsOrderSetting)
    {
        return omsOrderSettingMapper.selectOmsOrderSettingList(omsOrderSetting);
    }

    /**
     * 新增订单配置信息
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 结果
     */
    @Override
    public int insertOmsOrderSetting(OmsOrderSetting omsOrderSetting)
    {
        return omsOrderSettingMapper.insertOmsOrderSetting(omsOrderSetting);
    }

    /**
     * 修改订单配置信息
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 结果
     */
    @Override
    public int updateOmsOrderSetting(OmsOrderSetting omsOrderSetting)
    {
        return omsOrderSettingMapper.updateOmsOrderSetting(omsOrderSetting);
    }

    /**
     * 批量删除订单配置信息
     * 
     * @param ids 需要删除的订单配置信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderSettingByIds(Long[] ids)
    {
        return omsOrderSettingMapper.deleteOmsOrderSettingByIds(ids);
    }

    /**
     * 删除订单配置信息信息
     * 
     * @param id 订单配置信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderSettingById(Long id)
    {
        return omsOrderSettingMapper.deleteOmsOrderSettingById(id);
    }
}

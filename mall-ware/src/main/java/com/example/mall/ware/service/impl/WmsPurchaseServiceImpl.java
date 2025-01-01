package com.example.mall.ware.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mall.ware.mapper.WmsPurchaseMapper;
import com.example.mall.ware.domain.WmsPurchase;
import com.example.mall.ware.service.IWmsPurchaseService;

/**
 * 采购信息Service业务层处理
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@Service
public class WmsPurchaseServiceImpl implements IWmsPurchaseService 
{
    @Autowired
    private WmsPurchaseMapper wmsPurchaseMapper;

    /**
     * 查询采购信息
     * 
     * @param id 采购信息主键
     * @return 采购信息
     */
    @Override
    public WmsPurchase selectWmsPurchaseById(Long id)
    {
        return wmsPurchaseMapper.selectWmsPurchaseById(id);
    }

    /**
     * 查询采购信息列表
     * 
     * @param wmsPurchase 采购信息
     * @return 采购信息
     */
    @Override
    public List<WmsPurchase> selectWmsPurchaseList(WmsPurchase wmsPurchase)
    {
        return wmsPurchaseMapper.selectWmsPurchaseList(wmsPurchase);
    }

    /**
     * 新增采购信息
     * 
     * @param wmsPurchase 采购信息
     * @return 结果
     */
    @Override
    public int insertWmsPurchase(WmsPurchase wmsPurchase)
    {
        wmsPurchase.setCreateTime(DateUtils.getNowDate());
        return wmsPurchaseMapper.insertWmsPurchase(wmsPurchase);
    }

    /**
     * 修改采购信息
     * 
     * @param wmsPurchase 采购信息
     * @return 结果
     */
    @Override
    public int updateWmsPurchase(WmsPurchase wmsPurchase)
    {
        wmsPurchase.setUpdateTime(DateUtils.getNowDate());
        return wmsPurchaseMapper.updateWmsPurchase(wmsPurchase);
    }

    /**
     * 批量删除采购信息
     * 
     * @param ids 需要删除的采购信息主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseByIds(Long[] ids)
    {
        return wmsPurchaseMapper.deleteWmsPurchaseByIds(ids);
    }

    /**
     * 删除采购信息信息
     * 
     * @param id 采购信息主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseById(Long id)
    {
        return wmsPurchaseMapper.deleteWmsPurchaseById(id);
    }
}

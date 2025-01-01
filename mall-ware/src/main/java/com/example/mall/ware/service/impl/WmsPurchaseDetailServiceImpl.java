package com.example.mall.ware.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mall.ware.mapper.WmsPurchaseDetailMapper;
import com.example.mall.ware.domain.WmsPurchaseDetail;
import com.example.mall.ware.service.IWmsPurchaseDetailService;

/**
 * 采购信息细节Service业务层处理
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@Service
public class WmsPurchaseDetailServiceImpl implements IWmsPurchaseDetailService 
{
    @Autowired
    private WmsPurchaseDetailMapper wmsPurchaseDetailMapper;

    /**
     * 查询采购信息细节
     * 
     * @param id 采购信息细节主键
     * @return 采购信息细节
     */
    @Override
    public WmsPurchaseDetail selectWmsPurchaseDetailById(Long id)
    {
        return wmsPurchaseDetailMapper.selectWmsPurchaseDetailById(id);
    }

    /**
     * 查询采购信息细节列表
     * 
     * @param wmsPurchaseDetail 采购信息细节
     * @return 采购信息细节
     */
    @Override
    public List<WmsPurchaseDetail> selectWmsPurchaseDetailList(WmsPurchaseDetail wmsPurchaseDetail)
    {
        return wmsPurchaseDetailMapper.selectWmsPurchaseDetailList(wmsPurchaseDetail);
    }

    /**
     * 新增采购信息细节
     * 
     * @param wmsPurchaseDetail 采购信息细节
     * @return 结果
     */
    @Override
    public int insertWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail)
    {
        return wmsPurchaseDetailMapper.insertWmsPurchaseDetail(wmsPurchaseDetail);
    }

    /**
     * 修改采购信息细节
     * 
     * @param wmsPurchaseDetail 采购信息细节
     * @return 结果
     */
    @Override
    public int updateWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail)
    {
        return wmsPurchaseDetailMapper.updateWmsPurchaseDetail(wmsPurchaseDetail);
    }

    /**
     * 批量删除采购信息细节
     * 
     * @param ids 需要删除的采购信息细节主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseDetailByIds(Long[] ids)
    {
        return wmsPurchaseDetailMapper.deleteWmsPurchaseDetailByIds(ids);
    }

    /**
     * 删除采购信息细节信息
     * 
     * @param id 采购信息细节主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseDetailById(Long id)
    {
        return wmsPurchaseDetailMapper.deleteWmsPurchaseDetailById(id);
    }
}

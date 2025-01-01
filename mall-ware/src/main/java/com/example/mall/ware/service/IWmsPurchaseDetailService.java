package com.example.mall.ware.service;

import java.util.List;
import com.example.mall.ware.domain.WmsPurchaseDetail;

/**
 * 采购信息细节Service接口
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public interface IWmsPurchaseDetailService 
{
    /**
     * 查询采购信息细节
     * 
     * @param id 采购信息细节主键
     * @return 采购信息细节
     */
    public WmsPurchaseDetail selectWmsPurchaseDetailById(Long id);

    /**
     * 查询采购信息细节列表
     * 
     * @param wmsPurchaseDetail 采购信息细节
     * @return 采购信息细节集合
     */
    public List<WmsPurchaseDetail> selectWmsPurchaseDetailList(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 新增采购信息细节
     * 
     * @param wmsPurchaseDetail 采购信息细节
     * @return 结果
     */
    public int insertWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 修改采购信息细节
     * 
     * @param wmsPurchaseDetail 采购信息细节
     * @return 结果
     */
    public int updateWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 批量删除采购信息细节
     * 
     * @param ids 需要删除的采购信息细节主键集合
     * @return 结果
     */
    public int deleteWmsPurchaseDetailByIds(Long[] ids);

    /**
     * 删除采购信息细节信息
     * 
     * @param id 采购信息细节主键
     * @return 结果
     */
    public int deleteWmsPurchaseDetailById(Long id);
}

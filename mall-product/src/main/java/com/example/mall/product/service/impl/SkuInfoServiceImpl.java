package com.example.mall.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mall.product.mapper.SkuInfoMapper;
import com.example.mall.product.domain.SkuInfo;
import com.example.mall.product.service.ISkuInfoService;

/**
 * sku信息Service业务层处理
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
@Service
public class SkuInfoServiceImpl implements ISkuInfoService 
{
    @Autowired
    private SkuInfoMapper skuInfoMapper;

    /**
     * 查询sku信息
     * 
     * @param skuId sku信息主键
     * @return sku信息
     */
    @Override
    public SkuInfo selectSkuInfoBySkuId(Long skuId)
    {
        return skuInfoMapper.selectSkuInfoBySkuId(skuId);
    }

    /**
     * 查询sku信息列表
     * 
     * @param skuInfo sku信息
     * @return sku信息
     */
    @Override
    public List<SkuInfo> selectSkuInfoList(SkuInfo skuInfo)
    {
        return skuInfoMapper.selectSkuInfoList(skuInfo);
    }

    /**
     * 新增sku信息
     * 
     * @param skuInfo sku信息
     * @return 结果
     */
    @Override
    public int insertSkuInfo(SkuInfo skuInfo)
    {
        return skuInfoMapper.insertSkuInfo(skuInfo);
    }

    /**
     * 修改sku信息
     * 
     * @param skuInfo sku信息
     * @return 结果
     */
    @Override
    public int updateSkuInfo(SkuInfo skuInfo)
    {
        return skuInfoMapper.updateSkuInfo(skuInfo);
    }

    /**
     * 批量删除sku信息
     * 
     * @param skuIds 需要删除的sku信息主键
     * @return 结果
     */
    @Override
    public int deleteSkuInfoBySkuIds(Long[] skuIds)
    {
        return skuInfoMapper.deleteSkuInfoBySkuIds(skuIds);
    }

    /**
     * 删除sku信息信息
     * 
     * @param skuId sku信息主键
     * @return 结果
     */
    @Override
    public int deleteSkuInfoBySkuId(Long skuId)
    {
        return skuInfoMapper.deleteSkuInfoBySkuId(skuId);
    }
}

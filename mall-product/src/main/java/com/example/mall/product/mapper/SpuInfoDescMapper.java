package com.example.mall.product.mapper;

import java.util.List;
import com.example.mall.product.domain.SpuInfoDesc;

/**
 * spu信息介绍Mapper接口
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
public interface SpuInfoDescMapper 
{
    /**
     * 查询spu信息介绍
     * 
     * @param spuId spu信息介绍主键
     * @return spu信息介绍
     */
    public SpuInfoDesc selectSpuInfoDescBySpuId(Long spuId);

    /**
     * 查询spu信息介绍列表
     * 
     * @param spuInfoDesc spu信息介绍
     * @return spu信息介绍集合
     */
    public List<SpuInfoDesc> selectSpuInfoDescList(SpuInfoDesc spuInfoDesc);

    /**
     * 新增spu信息介绍
     * 
     * @param spuInfoDesc spu信息介绍
     * @return 结果
     */
    public int insertSpuInfoDesc(SpuInfoDesc spuInfoDesc);

    /**
     * 修改spu信息介绍
     * 
     * @param spuInfoDesc spu信息介绍
     * @return 结果
     */
    public int updateSpuInfoDesc(SpuInfoDesc spuInfoDesc);

    /**
     * 删除spu信息介绍
     * 
     * @param spuId spu信息介绍主键
     * @return 结果
     */
    public int deleteSpuInfoDescBySpuId(Long spuId);

    /**
     * 批量删除spu信息介绍
     * 
     * @param spuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpuInfoDescBySpuIds(Long[] spuIds);
}

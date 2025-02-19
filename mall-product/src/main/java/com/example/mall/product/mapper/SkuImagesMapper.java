package com.example.mall.product.mapper;

import java.util.List;
import com.example.mall.product.domain.SkuImages;

/**
 * sku图片Mapper接口
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
public interface SkuImagesMapper 
{
    /**
     * 查询sku图片
     * 
     * @param id sku图片主键
     * @return sku图片
     */
    public SkuImages selectSkuImagesById(Long id);

    /**
     * 查询sku图片列表
     * 
     * @param skuImages sku图片
     * @return sku图片集合
     */
    public List<SkuImages> selectSkuImagesList(SkuImages skuImages);

    /**
     * 新增sku图片
     * 
     * @param skuImages sku图片
     * @return 结果
     */
    public int insertSkuImages(SkuImages skuImages);

    /**
     * 修改sku图片
     * 
     * @param skuImages sku图片
     * @return 结果
     */
    public int updateSkuImages(SkuImages skuImages);

    /**
     * 删除sku图片
     * 
     * @param id sku图片主键
     * @return 结果
     */
    public int deleteSkuImagesById(Long id);

    /**
     * 批量删除sku图片
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSkuImagesByIds(Long[] ids);
}

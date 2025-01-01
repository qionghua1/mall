package com.example.mall.product.service;

import java.util.List;
import com.example.mall.product.domain.Category;

/**
 * 商品三级分类Service接口
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
public interface ICategoryService 
{
    /**
     * 查询商品三级分类
     * 
     * @param catId 商品三级分类主键
     * @return 商品三级分类
     */
    public Category selectCategoryByCatId(Long catId);

    /**
     * 查询商品三级分类列表
     * 
     * @param category 商品三级分类
     * @return 商品三级分类集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增商品三级分类
     * 
     * @param category 商品三级分类
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改商品三级分类
     * 
     * @param category 商品三级分类
     * @return 结果
     */
    public int updateCategory(Category category);

    /**
     * 批量删除商品三级分类
     * 
     * @param catIds 需要删除的商品三级分类主键集合
     * @return 结果
     */
    public int deleteCategoryByCatIds(Long[] catIds);

    /**
     * 删除商品三级分类信息
     * 
     * @param catId 商品三级分类主键
     * @return 结果
     */
    public int deleteCategoryByCatId(Long catId);
}

package com.example.mall.product.mapper;

import java.util.List;
import com.example.mall.product.domain.Attr;

/**
 * 商品属性Mapper接口
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
public interface AttrMapper 
{
    /**
     * 查询商品属性
     * 
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    public Attr selectAttrByAttrId(Long attrId);

    /**
     * 查询商品属性列表
     * 
     * @param attr 商品属性
     * @return 商品属性集合
     */
    public List<Attr> selectAttrList(Attr attr);

    /**
     * 新增商品属性
     * 
     * @param attr 商品属性
     * @return 结果
     */
    public int insertAttr(Attr attr);

    /**
     * 修改商品属性
     * 
     * @param attr 商品属性
     * @return 结果
     */
    public int updateAttr(Attr attr);

    /**
     * 删除商品属性
     * 
     * @param attrId 商品属性主键
     * @return 结果
     */
    public int deleteAttrByAttrId(Long attrId);

    /**
     * 批量删除商品属性
     * 
     * @param attrIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAttrByAttrIds(Long[] attrIds);
}

package com.example.mall.member.mapper;

import java.util.List;
import com.example.mall.member.domain.UmsMemberCollectSpu;

/**
 * 会员收藏的商品Mapper接口
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public interface UmsMemberCollectSpuMapper 
{
    /**
     * 查询会员收藏的商品
     * 
     * @param id 会员收藏的商品主键
     * @return 会员收藏的商品
     */
    public UmsMemberCollectSpu selectUmsMemberCollectSpuById(Long id);

    /**
     * 查询会员收藏的商品列表
     * 
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品集合
     */
    public List<UmsMemberCollectSpu> selectUmsMemberCollectSpuList(UmsMemberCollectSpu umsMemberCollectSpu);

    /**
     * 新增会员收藏的商品
     * 
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 结果
     */
    public int insertUmsMemberCollectSpu(UmsMemberCollectSpu umsMemberCollectSpu);

    /**
     * 修改会员收藏的商品
     * 
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 结果
     */
    public int updateUmsMemberCollectSpu(UmsMemberCollectSpu umsMemberCollectSpu);

    /**
     * 删除会员收藏的商品
     * 
     * @param id 会员收藏的商品主键
     * @return 结果
     */
    public int deleteUmsMemberCollectSpuById(Long id);

    /**
     * 批量删除会员收藏的商品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUmsMemberCollectSpuByIds(Long[] ids);
}

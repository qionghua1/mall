package com.example.mall.member.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mall.member.mapper.UmsMemberCollectSpuMapper;
import com.example.mall.member.domain.UmsMemberCollectSpu;
import com.example.mall.member.service.IUmsMemberCollectSpuService;

/**
 * 会员收藏的商品Service业务层处理
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@Service
public class UmsMemberCollectSpuServiceImpl implements IUmsMemberCollectSpuService 
{
    @Autowired
    private UmsMemberCollectSpuMapper umsMemberCollectSpuMapper;

    /**
     * 查询会员收藏的商品
     * 
     * @param id 会员收藏的商品主键
     * @return 会员收藏的商品
     */
    @Override
    public UmsMemberCollectSpu selectUmsMemberCollectSpuById(Long id)
    {
        return umsMemberCollectSpuMapper.selectUmsMemberCollectSpuById(id);
    }

    /**
     * 查询会员收藏的商品列表
     * 
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品
     */
    @Override
    public List<UmsMemberCollectSpu> selectUmsMemberCollectSpuList(UmsMemberCollectSpu umsMemberCollectSpu)
    {
        return umsMemberCollectSpuMapper.selectUmsMemberCollectSpuList(umsMemberCollectSpu);
    }

    /**
     * 新增会员收藏的商品
     * 
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 结果
     */
    @Override
    public int insertUmsMemberCollectSpu(UmsMemberCollectSpu umsMemberCollectSpu)
    {
        umsMemberCollectSpu.setCreateTime(DateUtils.getNowDate());
        return umsMemberCollectSpuMapper.insertUmsMemberCollectSpu(umsMemberCollectSpu);
    }

    /**
     * 修改会员收藏的商品
     * 
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 结果
     */
    @Override
    public int updateUmsMemberCollectSpu(UmsMemberCollectSpu umsMemberCollectSpu)
    {
        return umsMemberCollectSpuMapper.updateUmsMemberCollectSpu(umsMemberCollectSpu);
    }

    /**
     * 批量删除会员收藏的商品
     * 
     * @param ids 需要删除的会员收藏的商品主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberCollectSpuByIds(Long[] ids)
    {
        return umsMemberCollectSpuMapper.deleteUmsMemberCollectSpuByIds(ids);
    }

    /**
     * 删除会员收藏的商品信息
     * 
     * @param id 会员收藏的商品主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberCollectSpuById(Long id)
    {
        return umsMemberCollectSpuMapper.deleteUmsMemberCollectSpuById(id);
    }
}

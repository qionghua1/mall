package com.example.mall.product.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mall.product.mapper.SpuCommentMapper;
import com.example.mall.product.domain.SpuComment;
import com.example.mall.product.service.ISpuCommentService;

/**
 * 商品评价Service业务层处理
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
@Service
public class SpuCommentServiceImpl implements ISpuCommentService 
{
    @Autowired
    private SpuCommentMapper spuCommentMapper;

    /**
     * 查询商品评价
     * 
     * @param id 商品评价主键
     * @return 商品评价
     */
    @Override
    public SpuComment selectSpuCommentById(Long id)
    {
        return spuCommentMapper.selectSpuCommentById(id);
    }

    /**
     * 查询商品评价列表
     * 
     * @param spuComment 商品评价
     * @return 商品评价
     */
    @Override
    public List<SpuComment> selectSpuCommentList(SpuComment spuComment)
    {
        return spuCommentMapper.selectSpuCommentList(spuComment);
    }

    /**
     * 新增商品评价
     * 
     * @param spuComment 商品评价
     * @return 结果
     */
    @Override
    public int insertSpuComment(SpuComment spuComment)
    {
        spuComment.setCreateTime(DateUtils.getNowDate());
        return spuCommentMapper.insertSpuComment(spuComment);
    }

    /**
     * 修改商品评价
     * 
     * @param spuComment 商品评价
     * @return 结果
     */
    @Override
    public int updateSpuComment(SpuComment spuComment)
    {
        return spuCommentMapper.updateSpuComment(spuComment);
    }

    /**
     * 批量删除商品评价
     * 
     * @param ids 需要删除的商品评价主键
     * @return 结果
     */
    @Override
    public int deleteSpuCommentByIds(Long[] ids)
    {
        return spuCommentMapper.deleteSpuCommentByIds(ids);
    }

    /**
     * 删除商品评价信息
     * 
     * @param id 商品评价主键
     * @return 结果
     */
    @Override
    public int deleteSpuCommentById(Long id)
    {
        return spuCommentMapper.deleteSpuCommentById(id);
    }
}

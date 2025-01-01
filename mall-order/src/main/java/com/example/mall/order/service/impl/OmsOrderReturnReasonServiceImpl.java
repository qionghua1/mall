package com.example.mall.order.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mall.order.mapper.OmsOrderReturnReasonMapper;
import com.example.mall.order.domain.OmsOrderReturnReason;
import com.example.mall.order.service.IOmsOrderReturnReasonService;

/**
 * 退货原因Service业务层处理
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@Service
public class OmsOrderReturnReasonServiceImpl implements IOmsOrderReturnReasonService 
{
    @Autowired
    private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;

    /**
     * 查询退货原因
     * 
     * @param id 退货原因主键
     * @return 退货原因
     */
    @Override
    public OmsOrderReturnReason selectOmsOrderReturnReasonById(Long id)
    {
        return omsOrderReturnReasonMapper.selectOmsOrderReturnReasonById(id);
    }

    /**
     * 查询退货原因列表
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 退货原因
     */
    @Override
    public List<OmsOrderReturnReason> selectOmsOrderReturnReasonList(OmsOrderReturnReason omsOrderReturnReason)
    {
        return omsOrderReturnReasonMapper.selectOmsOrderReturnReasonList(omsOrderReturnReason);
    }

    /**
     * 新增退货原因
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    @Override
    public int insertOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason)
    {
        omsOrderReturnReason.setCreateTime(DateUtils.getNowDate());
        return omsOrderReturnReasonMapper.insertOmsOrderReturnReason(omsOrderReturnReason);
    }

    /**
     * 修改退货原因
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    @Override
    public int updateOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason)
    {
        return omsOrderReturnReasonMapper.updateOmsOrderReturnReason(omsOrderReturnReason);
    }

    /**
     * 批量删除退货原因
     * 
     * @param ids 需要删除的退货原因主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderReturnReasonByIds(Long[] ids)
    {
        return omsOrderReturnReasonMapper.deleteOmsOrderReturnReasonByIds(ids);
    }

    /**
     * 删除退货原因信息
     * 
     * @param id 退货原因主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderReturnReasonById(Long id)
    {
        return omsOrderReturnReasonMapper.deleteOmsOrderReturnReasonById(id);
    }
}

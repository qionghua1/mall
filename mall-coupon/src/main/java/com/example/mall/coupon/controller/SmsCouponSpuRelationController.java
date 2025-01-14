package com.example.mall.coupon.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.example.mall.coupon.domain.SmsCouponSpuRelation;
import com.example.mall.coupon.service.ISmsCouponSpuRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 优惠券与产品关联Controller
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
@RestController
@RequestMapping("/coupon/couponSpuRelation")
public class SmsCouponSpuRelationController extends BaseController
{
    @Autowired
    private ISmsCouponSpuRelationService smsCouponSpuRelationService;

    /**
     * 查询优惠券与产品关联列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:couponSpuRelation:list')")
    @GetMapping("/list")
    public TableDataInfo list(SmsCouponSpuRelation smsCouponSpuRelation)
    {
        startPage();
        List<SmsCouponSpuRelation> list = smsCouponSpuRelationService.selectSmsCouponSpuRelationList(smsCouponSpuRelation);
        return getDataTable(list);
    }

    /**
     * 导出优惠券与产品关联列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:couponSpuRelation:export')")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCouponSpuRelation smsCouponSpuRelation)
    {
        List<SmsCouponSpuRelation> list = smsCouponSpuRelationService.selectSmsCouponSpuRelationList(smsCouponSpuRelation);
        ExcelUtil<SmsCouponSpuRelation> util = new ExcelUtil<SmsCouponSpuRelation>(SmsCouponSpuRelation.class);
        util.exportExcel(response, list, "优惠券与产品关联数据");
    }

    /**
     * 获取优惠券与产品关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:couponSpuRelation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponSpuRelationService.selectSmsCouponSpuRelationById(id));
    }

    /**
     * 新增优惠券与产品关联
     */
    @PreAuthorize("@ss.hasPermi('coupon:couponSpuRelation:add')")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return toAjax(smsCouponSpuRelationService.insertSmsCouponSpuRelation(smsCouponSpuRelation));
    }

    /**
     * 修改优惠券与产品关联
     */
    @PreAuthorize("@ss.hasPermi('coupon:couponSpuRelation:edit')")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return toAjax(smsCouponSpuRelationService.updateSmsCouponSpuRelation(smsCouponSpuRelation));
    }

    /**
     * 删除优惠券与产品关联
     */
    @PreAuthorize("@ss.hasPermi('coupon:couponSpuRelation:remove')")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponSpuRelationService.deleteSmsCouponSpuRelationByIds(ids));
    }
}

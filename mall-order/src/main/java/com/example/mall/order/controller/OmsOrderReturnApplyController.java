package com.example.mall.order.controller;

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
import com.example.mall.order.domain.OmsOrderReturnApply;
import com.example.mall.order.service.IOmsOrderReturnApplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单退货申请Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/order/returnApply")
public class OmsOrderReturnApplyController extends BaseController
{
    @Autowired
    private IOmsOrderReturnApplyService omsOrderReturnApplyService;

    /**
     * 查询订单退货申请列表
     */
    @PreAuthorize("@ss.hasPermi('order:returnApply:list')")
    @GetMapping("/list")
    public TableDataInfo list(OmsOrderReturnApply omsOrderReturnApply)
    {
        startPage();
        List<OmsOrderReturnApply> list = omsOrderReturnApplyService.selectOmsOrderReturnApplyList(omsOrderReturnApply);
        return getDataTable(list);
    }

    /**
     * 导出订单退货申请列表
     */
    @PreAuthorize("@ss.hasPermi('order:returnApply:export')")
    @Log(title = "订单退货申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsOrderReturnApply omsOrderReturnApply)
    {
        List<OmsOrderReturnApply> list = omsOrderReturnApplyService.selectOmsOrderReturnApplyList(omsOrderReturnApply);
        ExcelUtil<OmsOrderReturnApply> util = new ExcelUtil<OmsOrderReturnApply>(OmsOrderReturnApply.class);
        util.exportExcel(response, list, "订单退货申请数据");
    }

    /**
     * 获取订单退货申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:returnApply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsOrderReturnApplyService.selectOmsOrderReturnApplyById(id));
    }

    /**
     * 新增订单退货申请
     */
    @PreAuthorize("@ss.hasPermi('order:returnApply:add')")
    @Log(title = "订单退货申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsOrderReturnApply omsOrderReturnApply)
    {
        return toAjax(omsOrderReturnApplyService.insertOmsOrderReturnApply(omsOrderReturnApply));
    }

    /**
     * 修改订单退货申请
     */
    @PreAuthorize("@ss.hasPermi('order:returnApply:edit')")
    @Log(title = "订单退货申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsOrderReturnApply omsOrderReturnApply)
    {
        return toAjax(omsOrderReturnApplyService.updateOmsOrderReturnApply(omsOrderReturnApply));
    }

    /**
     * 删除订单退货申请
     */
    @PreAuthorize("@ss.hasPermi('order:returnApply:remove')")
    @Log(title = "订单退货申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsOrderReturnApplyService.deleteOmsOrderReturnApplyByIds(ids));
    }
}

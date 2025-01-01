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
import com.example.mall.order.domain.OmsOrderItem;
import com.example.mall.order.service.IOmsOrderItemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单项信息Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/order/orderItem")
public class OmsOrderItemController extends BaseController
{
    @Autowired
    private IOmsOrderItemService omsOrderItemService;

    /**
     * 查询订单项信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:orderItem:list')")
    @GetMapping("/list")
    public TableDataInfo list(OmsOrderItem omsOrderItem)
    {
        startPage();
        List<OmsOrderItem> list = omsOrderItemService.selectOmsOrderItemList(omsOrderItem);
        return getDataTable(list);
    }

    /**
     * 导出订单项信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:orderItem:export')")
    @Log(title = "订单项信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsOrderItem omsOrderItem)
    {
        List<OmsOrderItem> list = omsOrderItemService.selectOmsOrderItemList(omsOrderItem);
        ExcelUtil<OmsOrderItem> util = new ExcelUtil<OmsOrderItem>(OmsOrderItem.class);
        util.exportExcel(response, list, "订单项信息数据");
    }

    /**
     * 获取订单项信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:orderItem:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsOrderItemService.selectOmsOrderItemById(id));
    }

    /**
     * 新增订单项信息
     */
    @PreAuthorize("@ss.hasPermi('order:orderItem:add')")
    @Log(title = "订单项信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsOrderItem omsOrderItem)
    {
        return toAjax(omsOrderItemService.insertOmsOrderItem(omsOrderItem));
    }

    /**
     * 修改订单项信息
     */
    @PreAuthorize("@ss.hasPermi('order:orderItem:edit')")
    @Log(title = "订单项信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsOrderItem omsOrderItem)
    {
        return toAjax(omsOrderItemService.updateOmsOrderItem(omsOrderItem));
    }

    /**
     * 删除订单项信息
     */
    @PreAuthorize("@ss.hasPermi('order:orderItem:remove')")
    @Log(title = "订单项信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsOrderItemService.deleteOmsOrderItemByIds(ids));
    }
}

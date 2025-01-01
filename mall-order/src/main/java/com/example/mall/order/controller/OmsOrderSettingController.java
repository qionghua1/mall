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
import com.example.mall.order.domain.OmsOrderSetting;
import com.example.mall.order.service.IOmsOrderSettingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单配置信息Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/order/setting")
public class OmsOrderSettingController extends BaseController
{
    @Autowired
    private IOmsOrderSettingService omsOrderSettingService;

    /**
     * 查询订单配置信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:setting:list')")
    @GetMapping("/list")
    public TableDataInfo list(OmsOrderSetting omsOrderSetting)
    {
        startPage();
        List<OmsOrderSetting> list = omsOrderSettingService.selectOmsOrderSettingList(omsOrderSetting);
        return getDataTable(list);
    }

    /**
     * 导出订单配置信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:setting:export')")
    @Log(title = "订单配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsOrderSetting omsOrderSetting)
    {
        List<OmsOrderSetting> list = omsOrderSettingService.selectOmsOrderSettingList(omsOrderSetting);
        ExcelUtil<OmsOrderSetting> util = new ExcelUtil<OmsOrderSetting>(OmsOrderSetting.class);
        util.exportExcel(response, list, "订单配置信息数据");
    }

    /**
     * 获取订单配置信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:setting:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsOrderSettingService.selectOmsOrderSettingById(id));
    }

    /**
     * 新增订单配置信息
     */
    @PreAuthorize("@ss.hasPermi('order:setting:add')")
    @Log(title = "订单配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsOrderSetting omsOrderSetting)
    {
        return toAjax(omsOrderSettingService.insertOmsOrderSetting(omsOrderSetting));
    }

    /**
     * 修改订单配置信息
     */
    @PreAuthorize("@ss.hasPermi('order:setting:edit')")
    @Log(title = "订单配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsOrderSetting omsOrderSetting)
    {
        return toAjax(omsOrderSettingService.updateOmsOrderSetting(omsOrderSetting));
    }

    /**
     * 删除订单配置信息
     */
    @PreAuthorize("@ss.hasPermi('order:setting:remove')")
    @Log(title = "订单配置信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsOrderSettingService.deleteOmsOrderSettingByIds(ids));
    }
}

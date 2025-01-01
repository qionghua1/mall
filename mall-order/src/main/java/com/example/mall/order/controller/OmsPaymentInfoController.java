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
import com.example.mall.order.domain.OmsPaymentInfo;
import com.example.mall.order.service.IOmsPaymentInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付信息Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/order/paymentInfo")
public class OmsPaymentInfoController extends BaseController
{
    @Autowired
    private IOmsPaymentInfoService omsPaymentInfoService;

    /**
     * 查询支付信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:paymentInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(OmsPaymentInfo omsPaymentInfo)
    {
        startPage();
        List<OmsPaymentInfo> list = omsPaymentInfoService.selectOmsPaymentInfoList(omsPaymentInfo);
        return getDataTable(list);
    }

    /**
     * 导出支付信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:paymentInfo:export')")
    @Log(title = "支付信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsPaymentInfo omsPaymentInfo)
    {
        List<OmsPaymentInfo> list = omsPaymentInfoService.selectOmsPaymentInfoList(omsPaymentInfo);
        ExcelUtil<OmsPaymentInfo> util = new ExcelUtil<OmsPaymentInfo>(OmsPaymentInfo.class);
        util.exportExcel(response, list, "支付信息数据");
    }

    /**
     * 获取支付信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:paymentInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsPaymentInfoService.selectOmsPaymentInfoById(id));
    }

    /**
     * 新增支付信息
     */
    @PreAuthorize("@ss.hasPermi('order:paymentInfo:add')")
    @Log(title = "支付信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsPaymentInfo omsPaymentInfo)
    {
        return toAjax(omsPaymentInfoService.insertOmsPaymentInfo(omsPaymentInfo));
    }

    /**
     * 修改支付信息
     */
    @PreAuthorize("@ss.hasPermi('order:paymentInfo:edit')")
    @Log(title = "支付信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsPaymentInfo omsPaymentInfo)
    {
        return toAjax(omsPaymentInfoService.updateOmsPaymentInfo(omsPaymentInfo));
    }

    /**
     * 删除支付信息
     */
    @PreAuthorize("@ss.hasPermi('order:paymentInfo:remove')")
    @Log(title = "支付信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsPaymentInfoService.deleteOmsPaymentInfoByIds(ids));
    }
}

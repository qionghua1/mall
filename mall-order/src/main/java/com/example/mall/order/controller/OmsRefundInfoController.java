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
import com.example.mall.order.domain.OmsRefundInfo;
import com.example.mall.order.service.IOmsRefundInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 退款信息Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/order/refundInfo")
public class OmsRefundInfoController extends BaseController
{
    @Autowired
    private IOmsRefundInfoService omsRefundInfoService;

    /**
     * 查询退款信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:refundInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(OmsRefundInfo omsRefundInfo)
    {
        startPage();
        List<OmsRefundInfo> list = omsRefundInfoService.selectOmsRefundInfoList(omsRefundInfo);
        return getDataTable(list);
    }

    /**
     * 导出退款信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:refundInfo:export')")
    @Log(title = "退款信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsRefundInfo omsRefundInfo)
    {
        List<OmsRefundInfo> list = omsRefundInfoService.selectOmsRefundInfoList(omsRefundInfo);
        ExcelUtil<OmsRefundInfo> util = new ExcelUtil<OmsRefundInfo>(OmsRefundInfo.class);
        util.exportExcel(response, list, "退款信息数据");
    }

    /**
     * 获取退款信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:refundInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsRefundInfoService.selectOmsRefundInfoById(id));
    }

    /**
     * 新增退款信息
     */
    @PreAuthorize("@ss.hasPermi('order:refundInfo:add')")
    @Log(title = "退款信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsRefundInfo omsRefundInfo)
    {
        return toAjax(omsRefundInfoService.insertOmsRefundInfo(omsRefundInfo));
    }

    /**
     * 修改退款信息
     */
    @PreAuthorize("@ss.hasPermi('order:refundInfo:edit')")
    @Log(title = "退款信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsRefundInfo omsRefundInfo)
    {
        return toAjax(omsRefundInfoService.updateOmsRefundInfo(omsRefundInfo));
    }

    /**
     * 删除退款信息
     */
    @PreAuthorize("@ss.hasPermi('order:refundInfo:remove')")
    @Log(title = "退款信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsRefundInfoService.deleteOmsRefundInfoByIds(ids));
    }
}

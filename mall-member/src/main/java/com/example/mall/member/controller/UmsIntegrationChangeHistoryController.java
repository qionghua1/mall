package com.example.mall.member.controller;

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
import com.example.mall.member.domain.UmsIntegrationChangeHistory;
import com.example.mall.member.service.IUmsIntegrationChangeHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分变化历史记录Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/member/integrationChangeHistory")
public class UmsIntegrationChangeHistoryController extends BaseController
{
    @Autowired
    private IUmsIntegrationChangeHistoryService umsIntegrationChangeHistoryService;

    /**
     * 查询积分变化历史记录列表
     */
    @PreAuthorize("@ss.hasPermi('member:integrationChangeHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        startPage();
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
        return getDataTable(list);
    }

    /**
     * 导出积分变化历史记录列表
     */
    @PreAuthorize("@ss.hasPermi('member:integrationChangeHistory:export')")
    @Log(title = "积分变化历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
        ExcelUtil<UmsIntegrationChangeHistory> util = new ExcelUtil<UmsIntegrationChangeHistory>(UmsIntegrationChangeHistory.class);
        util.exportExcel(response, list, "积分变化历史记录数据");
    }

    /**
     * 获取积分变化历史记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('member:integrationChangeHistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryById(id));
    }

    /**
     * 新增积分变化历史记录
     */
    @PreAuthorize("@ss.hasPermi('member:integrationChangeHistory:add')")
    @Log(title = "积分变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        return toAjax(umsIntegrationChangeHistoryService.insertUmsIntegrationChangeHistory(umsIntegrationChangeHistory));
    }

    /**
     * 修改积分变化历史记录
     */
    @PreAuthorize("@ss.hasPermi('member:integrationChangeHistory:edit')")
    @Log(title = "积分变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory)
    {
        return toAjax(umsIntegrationChangeHistoryService.updateUmsIntegrationChangeHistory(umsIntegrationChangeHistory));
    }

    /**
     * 删除积分变化历史记录
     */
    @PreAuthorize("@ss.hasPermi('member:integrationChangeHistory:remove')")
    @Log(title = "积分变化历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsIntegrationChangeHistoryService.deleteUmsIntegrationChangeHistoryByIds(ids));
    }
}

package com.example.mall.ware.controller;

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
import com.example.mall.ware.domain.WmsWareInfo;
import com.example.mall.ware.service.IWmsWareInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库信息Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/ware/wareInfo")
public class WmsWareInfoController extends BaseController
{
    @Autowired
    private IWmsWareInfoService wmsWareInfoService;

    /**
     * 查询仓库信息列表
     */
    @PreAuthorize("@ss.hasPermi('ware:wareInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmsWareInfo wmsWareInfo)
    {
        startPage();
        List<WmsWareInfo> list = wmsWareInfoService.selectWmsWareInfoList(wmsWareInfo);
        return getDataTable(list);
    }

    /**
     * 导出仓库信息列表
     */
    @PreAuthorize("@ss.hasPermi('ware:wareInfo:export')")
    @Log(title = "仓库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWareInfo wmsWareInfo)
    {
        List<WmsWareInfo> list = wmsWareInfoService.selectWmsWareInfoList(wmsWareInfo);
        ExcelUtil<WmsWareInfo> util = new ExcelUtil<WmsWareInfo>(WmsWareInfo.class);
        util.exportExcel(response, list, "仓库信息数据");
    }

    /**
     * 获取仓库信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('ware:wareInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsWareInfoService.selectWmsWareInfoById(id));
    }

    /**
     * 新增仓库信息
     */
    @PreAuthorize("@ss.hasPermi('ware:wareInfo:add')")
    @Log(title = "仓库信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWareInfo wmsWareInfo)
    {
        return toAjax(wmsWareInfoService.insertWmsWareInfo(wmsWareInfo));
    }

    /**
     * 修改仓库信息
     */
    @PreAuthorize("@ss.hasPermi('ware:wareInfo:edit')")
    @Log(title = "仓库信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWareInfo wmsWareInfo)
    {
        return toAjax(wmsWareInfoService.updateWmsWareInfo(wmsWareInfo));
    }

    /**
     * 删除仓库信息
     */
    @PreAuthorize("@ss.hasPermi('ware:wareInfo:remove')")
    @Log(title = "仓库信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsWareInfoService.deleteWmsWareInfoByIds(ids));
    }
}

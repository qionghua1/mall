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
import com.example.mall.ware.domain.WmsWareSku;
import com.example.mall.ware.service.IWmsWareSkuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品库存Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/ware/wareSku")
public class WmsWareSkuController extends BaseController
{
    @Autowired
    private IWmsWareSkuService wmsWareSkuService;

    /**
     * 查询商品库存列表
     */
    @PreAuthorize("@ss.hasPermi('ware:wareSku:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmsWareSku wmsWareSku)
    {
        startPage();
        List<WmsWareSku> list = wmsWareSkuService.selectWmsWareSkuList(wmsWareSku);
        return getDataTable(list);
    }

    /**
     * 导出商品库存列表
     */
    @PreAuthorize("@ss.hasPermi('ware:wareSku:export')")
    @Log(title = "商品库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWareSku wmsWareSku)
    {
        List<WmsWareSku> list = wmsWareSkuService.selectWmsWareSkuList(wmsWareSku);
        ExcelUtil<WmsWareSku> util = new ExcelUtil<WmsWareSku>(WmsWareSku.class);
        util.exportExcel(response, list, "商品库存数据");
    }

    /**
     * 获取商品库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('ware:wareSku:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsWareSkuService.selectWmsWareSkuById(id));
    }

    /**
     * 新增商品库存
     */
    @PreAuthorize("@ss.hasPermi('ware:wareSku:add')")
    @Log(title = "商品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWareSku wmsWareSku)
    {
        return toAjax(wmsWareSkuService.insertWmsWareSku(wmsWareSku));
    }

    /**
     * 修改商品库存
     */
    @PreAuthorize("@ss.hasPermi('ware:wareSku:edit')")
    @Log(title = "商品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWareSku wmsWareSku)
    {
        return toAjax(wmsWareSkuService.updateWmsWareSku(wmsWareSku));
    }

    /**
     * 删除商品库存
     */
    @PreAuthorize("@ss.hasPermi('ware:wareSku:remove')")
    @Log(title = "商品库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsWareSkuService.deleteWmsWareSkuByIds(ids));
    }
}

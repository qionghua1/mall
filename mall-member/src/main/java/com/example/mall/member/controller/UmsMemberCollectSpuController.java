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
import com.example.mall.member.domain.UmsMemberCollectSpu;
import com.example.mall.member.service.IUmsMemberCollectSpuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员收藏的商品Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/member/collectSpu")
public class UmsMemberCollectSpuController extends BaseController
{
    @Autowired
    private IUmsMemberCollectSpuService umsMemberCollectSpuService;

    /**
     * 查询会员收藏的商品列表
     */
    @PreAuthorize("@ss.hasPermi('member:collectSpu:list')")
    @GetMapping("/list")
    public TableDataInfo list(UmsMemberCollectSpu umsMemberCollectSpu)
    {
        startPage();
        List<UmsMemberCollectSpu> list = umsMemberCollectSpuService.selectUmsMemberCollectSpuList(umsMemberCollectSpu);
        return getDataTable(list);
    }

    /**
     * 导出会员收藏的商品列表
     */
    @PreAuthorize("@ss.hasPermi('member:collectSpu:export')")
    @Log(title = "会员收藏的商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMemberCollectSpu umsMemberCollectSpu)
    {
        List<UmsMemberCollectSpu> list = umsMemberCollectSpuService.selectUmsMemberCollectSpuList(umsMemberCollectSpu);
        ExcelUtil<UmsMemberCollectSpu> util = new ExcelUtil<UmsMemberCollectSpu>(UmsMemberCollectSpu.class);
        util.exportExcel(response, list, "会员收藏的商品数据");
    }

    /**
     * 获取会员收藏的商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('member:collectSpu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberCollectSpuService.selectUmsMemberCollectSpuById(id));
    }

    /**
     * 新增会员收藏的商品
     */
    @PreAuthorize("@ss.hasPermi('member:collectSpu:add')")
    @Log(title = "会员收藏的商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMemberCollectSpu umsMemberCollectSpu)
    {
        return toAjax(umsMemberCollectSpuService.insertUmsMemberCollectSpu(umsMemberCollectSpu));
    }

    /**
     * 修改会员收藏的商品
     */
    @PreAuthorize("@ss.hasPermi('member:collectSpu:edit')")
    @Log(title = "会员收藏的商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMemberCollectSpu umsMemberCollectSpu)
    {
        return toAjax(umsMemberCollectSpuService.updateUmsMemberCollectSpu(umsMemberCollectSpu));
    }

    /**
     * 删除会员收藏的商品
     */
    @PreAuthorize("@ss.hasPermi('member:collectSpu:remove')")
    @Log(title = "会员收藏的商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberCollectSpuService.deleteUmsMemberCollectSpuByIds(ids));
    }
}

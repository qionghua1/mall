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
import com.example.mall.member.domain.UmsMemberCollectSubject;
import com.example.mall.member.service.IUmsMemberCollectSubjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员收藏的专题活动Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/member/collectSubject")
public class UmsMemberCollectSubjectController extends BaseController
{
    @Autowired
    private IUmsMemberCollectSubjectService umsMemberCollectSubjectService;

    /**
     * 查询会员收藏的专题活动列表
     */
    @PreAuthorize("@ss.hasPermi('member:collectSubject:list')")
    @GetMapping("/list")
    public TableDataInfo list(UmsMemberCollectSubject umsMemberCollectSubject)
    {
        startPage();
        List<UmsMemberCollectSubject> list = umsMemberCollectSubjectService.selectUmsMemberCollectSubjectList(umsMemberCollectSubject);
        return getDataTable(list);
    }

    /**
     * 导出会员收藏的专题活动列表
     */
    @PreAuthorize("@ss.hasPermi('member:collectSubject:export')")
    @Log(title = "会员收藏的专题活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMemberCollectSubject umsMemberCollectSubject)
    {
        List<UmsMemberCollectSubject> list = umsMemberCollectSubjectService.selectUmsMemberCollectSubjectList(umsMemberCollectSubject);
        ExcelUtil<UmsMemberCollectSubject> util = new ExcelUtil<UmsMemberCollectSubject>(UmsMemberCollectSubject.class);
        util.exportExcel(response, list, "会员收藏的专题活动数据");
    }

    /**
     * 获取会员收藏的专题活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('member:collectSubject:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberCollectSubjectService.selectUmsMemberCollectSubjectById(id));
    }

    /**
     * 新增会员收藏的专题活动
     */
    @PreAuthorize("@ss.hasPermi('member:collectSubject:add')")
    @Log(title = "会员收藏的专题活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMemberCollectSubject umsMemberCollectSubject)
    {
        return toAjax(umsMemberCollectSubjectService.insertUmsMemberCollectSubject(umsMemberCollectSubject));
    }

    /**
     * 修改会员收藏的专题活动
     */
    @PreAuthorize("@ss.hasPermi('member:collectSubject:edit')")
    @Log(title = "会员收藏的专题活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMemberCollectSubject umsMemberCollectSubject)
    {
        return toAjax(umsMemberCollectSubjectService.updateUmsMemberCollectSubject(umsMemberCollectSubject));
    }

    /**
     * 删除会员收藏的专题活动
     */
    @PreAuthorize("@ss.hasPermi('member:collectSubject:remove')")
    @Log(title = "会员收藏的专题活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberCollectSubjectService.deleteUmsMemberCollectSubjectByIds(ids));
    }
}

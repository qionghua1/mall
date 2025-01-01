package com.example.mall.member.service;

import java.util.List;
import com.example.mall.member.domain.UmsMemberLoginLog;

/**
 * 会员登录记录Service接口
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public interface IUmsMemberLoginLogService 
{
    /**
     * 查询会员登录记录
     * 
     * @param id 会员登录记录主键
     * @return 会员登录记录
     */
    public UmsMemberLoginLog selectUmsMemberLoginLogById(Long id);

    /**
     * 查询会员登录记录列表
     * 
     * @param umsMemberLoginLog 会员登录记录
     * @return 会员登录记录集合
     */
    public List<UmsMemberLoginLog> selectUmsMemberLoginLogList(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 新增会员登录记录
     * 
     * @param umsMemberLoginLog 会员登录记录
     * @return 结果
     */
    public int insertUmsMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 修改会员登录记录
     * 
     * @param umsMemberLoginLog 会员登录记录
     * @return 结果
     */
    public int updateUmsMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 批量删除会员登录记录
     * 
     * @param ids 需要删除的会员登录记录主键集合
     * @return 结果
     */
    public int deleteUmsMemberLoginLogByIds(Long[] ids);

    /**
     * 删除会员登录记录信息
     * 
     * @param id 会员登录记录主键
     * @return 结果
     */
    public int deleteUmsMemberLoginLogById(Long id);
}

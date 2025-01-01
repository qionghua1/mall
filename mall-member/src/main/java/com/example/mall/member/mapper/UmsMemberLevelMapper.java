package com.example.mall.member.mapper;

import java.util.List;
import com.example.mall.member.domain.UmsMemberLevel;

/**
 * 会员等级Mapper接口
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public interface UmsMemberLevelMapper 
{
    /**
     * 查询会员等级
     * 
     * @param id 会员等级主键
     * @return 会员等级
     */
    public UmsMemberLevel selectUmsMemberLevelById(Long id);

    /**
     * 查询会员等级列表
     * 
     * @param umsMemberLevel 会员等级
     * @return 会员等级集合
     */
    public List<UmsMemberLevel> selectUmsMemberLevelList(UmsMemberLevel umsMemberLevel);

    /**
     * 新增会员等级
     * 
     * @param umsMemberLevel 会员等级
     * @return 结果
     */
    public int insertUmsMemberLevel(UmsMemberLevel umsMemberLevel);

    /**
     * 修改会员等级
     * 
     * @param umsMemberLevel 会员等级
     * @return 结果
     */
    public int updateUmsMemberLevel(UmsMemberLevel umsMemberLevel);

    /**
     * 删除会员等级
     * 
     * @param id 会员等级主键
     * @return 结果
     */
    public int deleteUmsMemberLevelById(Long id);

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUmsMemberLevelByIds(Long[] ids);
}

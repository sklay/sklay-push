package com.sklay.service;

import java.util.List;

import com.sklay.bean.UserGroup;
import com.sklay.core.query.Criteria;

public interface IUserGroupSV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserGroup queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param userGroup
	 * @return
	 * @throws Exception
	 */
	public UserGroup save(UserGroup userGroup)throws Exception;
	
	/**
	 * 更新
	 * @param userGroup
	 * @throws Exception
	 */
	public void update(UserGroup userGroup)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param userGroup
	 * @throws Exception
	 */
	public void saveOrUpdate(UserGroup userGroup)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<UserGroup> list)throws Exception;

	/**
	 * 按条件查询记录
	 * @param criteria
	 * @throws Exception
	 */
	public List<UserGroup> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

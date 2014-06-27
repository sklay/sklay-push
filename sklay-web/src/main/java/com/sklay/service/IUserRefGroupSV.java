package com.sklay.service;

import java.util.List;

import com.sklay.bean.UserRefGroup;
import com.sklay.core.query.Criteria;

public interface IUserRefGroupSV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserRefGroup queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param userRefGroup
	 * @return
	 * @throws Exception
	 */
	public UserRefGroup save(UserRefGroup userRefGroup)throws Exception;
	
	/**
	 * 更新
	 * @param userRefGroup
	 * @throws Exception
	 */
	public void update(UserRefGroup userRefGroup)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param userRefGroup
	 * @throws Exception
	 */
	public void saveOrUpdate(UserRefGroup userRefGroup)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<UserRefGroup> list)throws Exception;

	/**
	 * 按条件查询记录
	 * @param criteria
	 * @throws Exception
	 */
	public List<UserRefGroup> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

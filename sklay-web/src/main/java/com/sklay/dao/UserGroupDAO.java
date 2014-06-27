package com.sklay.dao;

import java.util.List;

import com.sklay.bean.UserGroup;
import com.sklay.core.query.Criteria;

public interface UserGroupDAO
{
	/**
	 * 查询全部数据
	 * @return List<userGroup>
	 * @throws Exception
	 */
	public List<UserGroup> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return userGroup
	 * @throws Exception
	 */
	public UserGroup queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param userGroup
	 * @return int
	 * @throws Exception
	 */
	public int insert(UserGroup userGroup)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param userGroups
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<UserGroup> userGroups)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param userGroup
	 * @return int
	 * @throws Exception
	 */
	public int update(UserGroup userGroup)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param userGroups
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<UserGroup> userGroups)throws Exception;
	
	/**
	 * 根据主键删除单个数据
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;
	
	/**
	 * 根据主键删除批量数据
	 * @param id
	 * @throws Exception
	 */
	public void deleteBatch(List<Long> ids)throws Exception;
	
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

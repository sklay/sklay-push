package com.sklay.dao;

import java.util.List;

import com.sklay.bean.UserRefGroup;
import com.sklay.core.query.Criteria;

public interface UserRefGroupDAO
{
	/**
	 * 查询全部数据
	 * @return List<userRefGroup>
	 * @throws Exception
	 */
	public List<UserRefGroup> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return userRefGroup
	 * @throws Exception
	 */
	public UserRefGroup queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param userRefGroup
	 * @return int
	 * @throws Exception
	 */
	public int insert(UserRefGroup userRefGroup)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param userRefGroups
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<UserRefGroup> userRefGroups)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param userRefGroup
	 * @return int
	 * @throws Exception
	 */
	public int update(UserRefGroup userRefGroup)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param userRefGroups
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<UserRefGroup> userRefGroups)throws Exception;
	
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
	public List<UserRefGroup> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

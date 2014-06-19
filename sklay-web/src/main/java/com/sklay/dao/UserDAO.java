package com.sklay.dao;

import java.util.List;

import com.sklay.bean.User;
import com.sklay.core.query.Criteria;

public interface UserDAO
{
	/**
	 * 查询全部数据
	 * @return List<user>
	 * @throws Exception
	 */
	public List<User> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return user
	 * @throws Exception
	 */
	public User queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param user
	 * @return int
	 * @throws Exception
	 */
	public int insert(User user)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param users
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<User> users)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param user
	 * @return int
	 * @throws Exception
	 */
	public int update(User user)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param users
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<User> users)throws Exception;
	
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
	public List<User> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

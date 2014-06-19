package com.sklay.service;

import java.util.List;

import com.sklay.bean.User;
import com.sklay.core.query.Criteria;

public interface IUserSV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User save(User user)throws Exception;
	
	/**
	 * 更新
	 * @param user
	 * @throws Exception
	 */
	public void update(User user)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param user
	 * @throws Exception
	 */
	public void saveOrUpdate(User user)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<User> list)throws Exception;

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

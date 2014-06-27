package com.sklay.dao;

import java.util.List;

import com.sklay.bean.UserFav;
import com.sklay.core.query.Criteria;

public interface UserFavDAO
{
	/**
	 * 查询全部数据
	 * @return List<userFav>
	 * @throws Exception
	 */
	public List<UserFav> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return userFav
	 * @throws Exception
	 */
	public UserFav queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param userFav
	 * @return int
	 * @throws Exception
	 */
	public int insert(UserFav userFav)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param userFavs
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<UserFav> userFavs)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param userFav
	 * @return int
	 * @throws Exception
	 */
	public int update(UserFav userFav)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param userFavs
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<UserFav> userFavs)throws Exception;
	
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
	public List<UserFav> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

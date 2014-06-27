package com.sklay.service;

import java.util.List;

import com.sklay.bean.UserFav;
import com.sklay.core.query.Criteria;

public interface IUserFavSV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserFav queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param userFav
	 * @return
	 * @throws Exception
	 */
	public UserFav save(UserFav userFav)throws Exception;
	
	/**
	 * 更新
	 * @param userFav
	 * @throws Exception
	 */
	public void update(UserFav userFav)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param userFav
	 * @throws Exception
	 */
	public void saveOrUpdate(UserFav userFav)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<UserFav> list)throws Exception;

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

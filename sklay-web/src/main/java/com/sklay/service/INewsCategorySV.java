package com.sklay.service;

import java.util.List;

import com.sklay.bean.NewsCategory;
import com.sklay.core.query.Criteria;

public interface INewsCategorySV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public NewsCategory queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param newsCategory
	 * @return
	 * @throws Exception
	 */
	public NewsCategory save(NewsCategory newsCategory)throws Exception;
	
	/**
	 * 更新
	 * @param newsCategory
	 * @throws Exception
	 */
	public void update(NewsCategory newsCategory)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param newsCategory
	 * @throws Exception
	 */
	public void saveOrUpdate(NewsCategory newsCategory)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<NewsCategory> list)throws Exception;

	/**
	 * 按条件查询记录
	 * @param criteria
	 * @throws Exception
	 */
	public List<NewsCategory> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

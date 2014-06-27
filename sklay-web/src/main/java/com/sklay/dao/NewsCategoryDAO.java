package com.sklay.dao;

import java.util.List;

import com.sklay.bean.NewsCategory;
import com.sklay.core.query.Criteria;

public interface NewsCategoryDAO
{
	/**
	 * 查询全部数据
	 * @return List<newsCategory>
	 * @throws Exception
	 */
	public List<NewsCategory> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return newsCategory
	 * @throws Exception
	 */
	public NewsCategory queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param newsCategory
	 * @return int
	 * @throws Exception
	 */
	public int insert(NewsCategory newsCategory)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param newsCategorys
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<NewsCategory> newsCategorys)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param newsCategory
	 * @return int
	 * @throws Exception
	 */
	public int update(NewsCategory newsCategory)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param newsCategorys
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<NewsCategory> newsCategorys)throws Exception;
	
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
	public List<NewsCategory> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

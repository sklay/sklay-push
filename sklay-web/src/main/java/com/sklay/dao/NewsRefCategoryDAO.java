package com.sklay.dao;

import java.util.List;

import com.sklay.bean.NewsRefCategory;
import com.sklay.core.query.Criteria;

public interface NewsRefCategoryDAO
{
	/**
	 * 查询全部数据
	 * @return List<newsRefCategory>
	 * @throws Exception
	 */
	public List<NewsRefCategory> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return newsRefCategory
	 * @throws Exception
	 */
	public NewsRefCategory queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param newsRefCategory
	 * @return int
	 * @throws Exception
	 */
	public int insert(NewsRefCategory newsRefCategory)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param newsRefCategorys
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<NewsRefCategory> newsRefCategorys)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param newsRefCategory
	 * @return int
	 * @throws Exception
	 */
	public int update(NewsRefCategory newsRefCategory)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param newsRefCategorys
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<NewsRefCategory> newsRefCategorys)throws Exception;
	
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
	public List<NewsRefCategory> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

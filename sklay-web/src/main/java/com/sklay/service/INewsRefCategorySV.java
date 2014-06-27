package com.sklay.service;

import java.util.List;

import com.sklay.bean.NewsRefCategory;
import com.sklay.core.query.Criteria;

public interface INewsRefCategorySV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public NewsRefCategory queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param newsRefCategory
	 * @return
	 * @throws Exception
	 */
	public NewsRefCategory save(NewsRefCategory newsRefCategory)throws Exception;
	
	/**
	 * 更新
	 * @param newsRefCategory
	 * @throws Exception
	 */
	public void update(NewsRefCategory newsRefCategory)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param newsRefCategory
	 * @throws Exception
	 */
	public void saveOrUpdate(NewsRefCategory newsRefCategory)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<NewsRefCategory> list)throws Exception;

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

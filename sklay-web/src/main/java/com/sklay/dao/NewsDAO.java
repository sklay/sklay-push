package com.sklay.dao;

import java.util.List;

import com.sklay.bean.News;
import com.sklay.core.query.Criteria;

public interface NewsDAO
{
	/**
	 * 查询全部数据
	 * @return List<news>
	 * @throws Exception
	 */
	public List<News> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return news
	 * @throws Exception
	 */
	public News queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param news
	 * @return int
	 * @throws Exception
	 */
	public int insert(News news)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param newss
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<News> newss)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param news
	 * @return int
	 * @throws Exception
	 */
	public int update(News news)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param newss
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<News> newss)throws Exception;
	
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
	public List<News> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

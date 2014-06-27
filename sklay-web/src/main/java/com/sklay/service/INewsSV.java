package com.sklay.service;

import java.util.List;

import com.sklay.bean.News;
import com.sklay.core.query.Criteria;

public interface INewsSV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public News queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param news
	 * @return
	 * @throws Exception
	 */
	public News save(News news)throws Exception;
	
	/**
	 * 更新
	 * @param news
	 * @throws Exception
	 */
	public void update(News news)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param news
	 * @throws Exception
	 */
	public void saveOrUpdate(News news)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<News> list)throws Exception;

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

package com.sklay.dao;

import java.util.List;

import com.sklay.bean.Push;
import com.sklay.core.query.Criteria;

public interface PushDAO
{
	/**
	 * 查询全部数据
	 * @return List<push>
	 * @throws Exception
	 */
	public List<Push> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return push
	 * @throws Exception
	 */
	public Push queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param push
	 * @return int
	 * @throws Exception
	 */
	public int insert(Push push)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param pushs
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<Push> pushs)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param push
	 * @return int
	 * @throws Exception
	 */
	public int update(Push push)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param pushs
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<Push> pushs)throws Exception;
	
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
	public List<Push> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

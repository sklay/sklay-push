package com.sklay.service;

import java.util.List;

import com.sklay.bean.Push;
import com.sklay.core.query.Criteria;

public interface IPushSV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Push queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param push
	 * @return
	 * @throws Exception
	 */
	public Push save(Push push)throws Exception;
	
	/**
	 * 更新
	 * @param push
	 * @throws Exception
	 */
	public void update(Push push)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param push
	 * @throws Exception
	 */
	public void saveOrUpdate(Push push)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<Push> list)throws Exception;

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

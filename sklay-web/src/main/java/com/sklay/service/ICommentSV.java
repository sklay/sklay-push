package com.sklay.service;

import java.util.List;

import com.sklay.bean.Comment;
import com.sklay.core.query.Criteria;

public interface ICommentSV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Comment queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public Comment save(Comment comment)throws Exception;
	
	/**
	 * 更新
	 * @param comment
	 * @throws Exception
	 */
	public void update(Comment comment)throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param comment
	 * @throws Exception
	 */
	public void saveOrUpdate(Comment comment)throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<Comment> list)throws Exception;

	/**
	 * 按条件查询记录
	 * @param criteria
	 * @throws Exception
	 */
	public List<Comment> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

package com.sklay.dao;

import java.util.List;

import com.sklay.bean.Comment;
import com.sklay.core.query.Criteria;

public interface CommentDAO
{
	/**
	 * 查询全部数据
	 * @return List<comment>
	 * @throws Exception
	 */
	public List<Comment> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return comment
	 * @throws Exception
	 */
	public Comment queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param comment
	 * @return int
	 * @throws Exception
	 */
	public int insert(Comment comment)throws Exception;
	
	/**
	 * 插入批量数据
	 * @param comments
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<Comment> comments)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param comment
	 * @return int
	 * @throws Exception
	 */
	public int update(Comment comment)throws Exception;
	
	/**
	 * 更新批量数据
	 * @param comments
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<Comment> comments)throws Exception;
	
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
	public List<Comment> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

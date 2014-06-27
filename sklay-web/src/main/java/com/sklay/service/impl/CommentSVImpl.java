package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.Comment;
import com.sklay.dao.CommentDAO;
import com.sklay.service.ICommentSV;
import com.sklay.core.query.Criteria;

@Service("commentSV")
public class CommentSVImpl implements ICommentSV
{
	@Resource
	private CommentDAO commentDAO;

	@Override
	public void delete(long id) throws Exception
	{
		commentDAO.delete(id);
	}

	@Override
	public Comment queryById(long id) throws Exception
	{
		return commentDAO.queryById(id);
	}

	@Override
	public Comment save(Comment comment) throws Exception
	{
		commentDAO.insert(comment);
		return comment;
	}

	@Override
	public void update(Comment comment) throws Exception
	{
		commentDAO.update(comment);
	}

	@Override
	public void saveOrUpdate(Comment comment)throws Exception
	{
		if(comment == null)return;
		if(comment.getId() > 0)
		{
			update(comment);
		}
		else
		{
			save(comment);
		}
	}

	@Override
	public void saveOrUpdate(List<Comment> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(Comment comment : list)
			{
				saveOrUpdate(comment);
			}
		}
	}

	@Override
	public List<Comment> queryByCondition(Criteria criteria)throws Exception
	{
		return commentDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return commentDAO.queryCountByCondition(criteria);
	}
}

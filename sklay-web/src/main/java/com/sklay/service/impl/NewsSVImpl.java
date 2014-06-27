package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.News;
import com.sklay.dao.NewsDAO;
import com.sklay.service.INewsSV;
import com.sklay.core.query.Criteria;

@Service("newsSV")
public class NewsSVImpl implements INewsSV
{
	@Resource
	private NewsDAO newsDAO;

	@Override
	public void delete(long id) throws Exception
	{
		newsDAO.delete(id);
	}

	@Override
	public News queryById(long id) throws Exception
	{
		return newsDAO.queryById(id);
	}

	@Override
	public News save(News news) throws Exception
	{
		newsDAO.insert(news);
		return news;
	}

	@Override
	public void update(News news) throws Exception
	{
		newsDAO.update(news);
	}

	@Override
	public void saveOrUpdate(News news)throws Exception
	{
		if(news == null)return;
		if(news.getId() > 0)
		{
			update(news);
		}
		else
		{
			save(news);
		}
	}

	@Override
	public void saveOrUpdate(List<News> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(News news : list)
			{
				saveOrUpdate(news);
			}
		}
	}

	@Override
	public List<News> queryByCondition(Criteria criteria)throws Exception
	{
		return newsDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return newsDAO.queryCountByCondition(criteria);
	}
}

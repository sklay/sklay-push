package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.NewsCategory;
import com.sklay.dao.NewsCategoryDAO;
import com.sklay.service.INewsCategorySV;
import com.sklay.core.query.Criteria;

@Service("newsCategorySV")
public class NewsCategorySVImpl implements INewsCategorySV
{
	@Resource
	private NewsCategoryDAO newsCategoryDAO;

	@Override
	public void delete(long id) throws Exception
	{
		newsCategoryDAO.delete(id);
	}

	@Override
	public NewsCategory queryById(long id) throws Exception
	{
		return newsCategoryDAO.queryById(id);
	}

	@Override
	public NewsCategory save(NewsCategory newsCategory) throws Exception
	{
		newsCategoryDAO.insert(newsCategory);
		return newsCategory;
	}

	@Override
	public void update(NewsCategory newsCategory) throws Exception
	{
		newsCategoryDAO.update(newsCategory);
	}

	@Override
	public void saveOrUpdate(NewsCategory newsCategory)throws Exception
	{
		if(newsCategory == null)return;
		if(newsCategory.getId() > 0)
		{
			update(newsCategory);
		}
		else
		{
			save(newsCategory);
		}
	}

	@Override
	public void saveOrUpdate(List<NewsCategory> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(NewsCategory newsCategory : list)
			{
				saveOrUpdate(newsCategory);
			}
		}
	}

	@Override
	public List<NewsCategory> queryByCondition(Criteria criteria)throws Exception
	{
		return newsCategoryDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return newsCategoryDAO.queryCountByCondition(criteria);
	}
}

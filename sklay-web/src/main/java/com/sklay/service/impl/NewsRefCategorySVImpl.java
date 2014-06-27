package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.NewsRefCategory;
import com.sklay.dao.NewsRefCategoryDAO;
import com.sklay.service.INewsRefCategorySV;
import com.sklay.core.query.Criteria;

@Service("newsRefCategorySV")
public class NewsRefCategorySVImpl implements INewsRefCategorySV
{
	@Resource
	private NewsRefCategoryDAO newsRefCategoryDAO;

	@Override
	public void delete(long id) throws Exception
	{
		newsRefCategoryDAO.delete(id);
	}

	@Override
	public NewsRefCategory queryById(long id) throws Exception
	{
		return newsRefCategoryDAO.queryById(id);
	}

	@Override
	public NewsRefCategory save(NewsRefCategory newsRefCategory) throws Exception
	{
		newsRefCategoryDAO.insert(newsRefCategory);
		return newsRefCategory;
	}

	@Override
	public void update(NewsRefCategory newsRefCategory) throws Exception
	{
		newsRefCategoryDAO.update(newsRefCategory);
	}

	@Override
	public void saveOrUpdate(NewsRefCategory newsRefCategory)throws Exception
	{
		if(newsRefCategory == null)return;
		if(newsRefCategory.getId() > 0)
		{
			update(newsRefCategory);
		}
		else
		{
			save(newsRefCategory);
		}
	}

	@Override
	public void saveOrUpdate(List<NewsRefCategory> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(NewsRefCategory newsRefCategory : list)
			{
				saveOrUpdate(newsRefCategory);
			}
		}
	}

	@Override
	public List<NewsRefCategory> queryByCondition(Criteria criteria)throws Exception
	{
		return newsRefCategoryDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return newsRefCategoryDAO.queryCountByCondition(criteria);
	}
}

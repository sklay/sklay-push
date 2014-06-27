package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.Push;
import com.sklay.dao.PushDAO;
import com.sklay.service.IPushSV;
import com.sklay.core.query.Criteria;

@Service("pushSV")
public class PushSVImpl implements IPushSV
{
	@Resource
	private PushDAO pushDAO;

	@Override
	public void delete(long id) throws Exception
	{
		pushDAO.delete(id);
	}

	@Override
	public Push queryById(long id) throws Exception
	{
		return pushDAO.queryById(id);
	}

	@Override
	public Push save(Push push) throws Exception
	{
		pushDAO.insert(push);
		return push;
	}

	@Override
	public void update(Push push) throws Exception
	{
		pushDAO.update(push);
	}

	@Override
	public void saveOrUpdate(Push push)throws Exception
	{
		if(push == null)return;
		if(push.getId() > 0)
		{
			update(push);
		}
		else
		{
			save(push);
		}
	}

	@Override
	public void saveOrUpdate(List<Push> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(Push push : list)
			{
				saveOrUpdate(push);
			}
		}
	}

	@Override
	public List<Push> queryByCondition(Criteria criteria)throws Exception
	{
		return pushDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return pushDAO.queryCountByCondition(criteria);
	}
}

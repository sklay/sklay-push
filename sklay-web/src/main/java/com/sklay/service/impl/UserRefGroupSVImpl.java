package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.UserRefGroup;
import com.sklay.dao.UserRefGroupDAO;
import com.sklay.service.IUserRefGroupSV;
import com.sklay.core.query.Criteria;

@Service("userRefGroupSV")
public class UserRefGroupSVImpl implements IUserRefGroupSV
{
	@Resource
	private UserRefGroupDAO userRefGroupDAO;

	@Override
	public void delete(long id) throws Exception
	{
		userRefGroupDAO.delete(id);
	}

	@Override
	public UserRefGroup queryById(long id) throws Exception
	{
		return userRefGroupDAO.queryById(id);
	}

	@Override
	public UserRefGroup save(UserRefGroup userRefGroup) throws Exception
	{
		userRefGroupDAO.insert(userRefGroup);
		return userRefGroup;
	}

	@Override
	public void update(UserRefGroup userRefGroup) throws Exception
	{
		userRefGroupDAO.update(userRefGroup);
	}

	@Override
	public void saveOrUpdate(UserRefGroup userRefGroup)throws Exception
	{
		if(userRefGroup == null)return;
		if(userRefGroup.getId() > 0)
		{
			update(userRefGroup);
		}
		else
		{
			save(userRefGroup);
		}
	}

	@Override
	public void saveOrUpdate(List<UserRefGroup> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(UserRefGroup userRefGroup : list)
			{
				saveOrUpdate(userRefGroup);
			}
		}
	}

	@Override
	public List<UserRefGroup> queryByCondition(Criteria criteria)throws Exception
	{
		return userRefGroupDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return userRefGroupDAO.queryCountByCondition(criteria);
	}
}

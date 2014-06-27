package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.UserGroup;
import com.sklay.dao.UserGroupDAO;
import com.sklay.service.IUserGroupSV;
import com.sklay.core.query.Criteria;

@Service("userGroupSV")
public class UserGroupSVImpl implements IUserGroupSV
{
	@Resource
	private UserGroupDAO userGroupDAO;

	@Override
	public void delete(long id) throws Exception
	{
		userGroupDAO.delete(id);
	}

	@Override
	public UserGroup queryById(long id) throws Exception
	{
		return userGroupDAO.queryById(id);
	}

	@Override
	public UserGroup save(UserGroup userGroup) throws Exception
	{
		userGroupDAO.insert(userGroup);
		return userGroup;
	}

	@Override
	public void update(UserGroup userGroup) throws Exception
	{
		userGroupDAO.update(userGroup);
	}

	@Override
	public void saveOrUpdate(UserGroup userGroup)throws Exception
	{
		if(userGroup == null)return;
		if(userGroup.getId() > 0)
		{
			update(userGroup);
		}
		else
		{
			save(userGroup);
		}
	}

	@Override
	public void saveOrUpdate(List<UserGroup> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(UserGroup userGroup : list)
			{
				saveOrUpdate(userGroup);
			}
		}
	}

	@Override
	public List<UserGroup> queryByCondition(Criteria criteria)throws Exception
	{
		return userGroupDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return userGroupDAO.queryCountByCondition(criteria);
	}
}

package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.User;
import com.sklay.dao.UserDAO;
import com.sklay.service.IUserSV;
import com.sklay.core.query.Criteria;

@Service("userSV")
public class UserSVImpl implements IUserSV
{
    
	@Resource
	private UserDAO userDAO;

	@Override
	public void delete(long id) throws Exception
	{
		userDAO.delete(id);
	}

	@Override
	public User queryById(long id) throws Exception
	{
		return userDAO.queryById(id);
	}

	@Override
	public User save(User user) throws Exception
	{
		userDAO.insert(user);
		return user;
	}

	@Override
	public void update(User user) throws Exception
	{
		userDAO.update(user);
	}

	@Override
	public void saveOrUpdate(User user)throws Exception
	{
		if(user == null)return;
		if(user.getId() > 0)
		{
			update(user);
		}
		else
		{
			save(user);
		}
	}

	@Override
	public void saveOrUpdate(List<User> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(User user : list)
			{
				saveOrUpdate(user);
			}
		}
	}

	@Override
	public List<User> queryByCondition(Criteria criteria)throws Exception
	{
		return userDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return userDAO.queryCountByCondition(criteria);
	}
}

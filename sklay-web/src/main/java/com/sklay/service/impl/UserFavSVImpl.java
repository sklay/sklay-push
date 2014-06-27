package com.sklay.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sklay.bean.UserFav;
import com.sklay.dao.UserFavDAO;
import com.sklay.service.IUserFavSV;
import com.sklay.core.query.Criteria;

@Service("userFavSV")
public class UserFavSVImpl implements IUserFavSV
{
	@Resource
	private UserFavDAO userFavDAO;

	@Override
	public void delete(long id) throws Exception
	{
		userFavDAO.delete(id);
	}

	@Override
	public UserFav queryById(long id) throws Exception
	{
		return userFavDAO.queryById(id);
	}

	@Override
	public UserFav save(UserFav userFav) throws Exception
	{
		userFavDAO.insert(userFav);
		return userFav;
	}

	@Override
	public void update(UserFav userFav) throws Exception
	{
		userFavDAO.update(userFav);
	}

	@Override
	public void saveOrUpdate(UserFav userFav)throws Exception
	{
		if(userFav == null)return;
		if(userFav.getId() > 0)
		{
			update(userFav);
		}
		else
		{
			save(userFav);
		}
	}

	@Override
	public void saveOrUpdate(List<UserFav> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(UserFav userFav : list)
			{
				saveOrUpdate(userFav);
			}
		}
	}

	@Override
	public List<UserFav> queryByCondition(Criteria criteria)throws Exception
	{
		return userFavDAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return userFavDAO.queryCountByCondition(criteria);
	}
}

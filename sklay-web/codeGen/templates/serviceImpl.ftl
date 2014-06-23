package ${package}.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import ${package}.bean.${Bean};
import ${package}.dao.${Bean}DAO;
import ${package}.service.I${Bean}SV;
import com.sklay.core.query.Criteria;

@Service("${bean}SV")
public class ${Bean}SVImpl implements I${Bean}SV
{
	@Resource
	private ${Bean}DAO ${bean}DAO;

	@Override
	public void delete(long id) throws Exception
	{
		${bean}DAO.delete(id);
	}

	@Override
	public ${Bean} queryById(long id) throws Exception
	{
		return ${bean}DAO.queryById(id);
	}

	@Override
	public ${Bean} save(${Bean} ${bean}) throws Exception
	{
		${bean}DAO.insert(${bean});
		return ${bean};
	}

	@Override
	public void update(${Bean} ${bean}) throws Exception
	{
		${bean}DAO.update(${bean});
	}

	@Override
	public void saveOrUpdate(${Bean} ${bean})throws Exception
	{
		if(${bean} == null)return;
		if(${bean}.getId() > 0)
		{
			update(${bean});
		}
		else
		{
			save(${bean});
		}
	}

	@Override
	public void saveOrUpdate(List<${Bean}> list)throws Exception
	{
		if(list != null && list.size() > 0)
		{
			for(${Bean} ${bean} : list)
			{
				saveOrUpdate(${bean});
			}
		}
	}

	@Override
	public List<${Bean}> queryByCondition(Criteria criteria)throws Exception
	{
		return ${bean}DAO.queryByCondition(criteria);
	}
	
	@Override
	public int queryCountByCondition(Criteria criteria)throws Exception
	{
		return ${bean}DAO.queryCountByCondition(criteria);
	}
}

package ${package}.dao;

import java.util.List;

import ${package}.bean.${Bean};
import com.sklay.core.query.Criteria;

public interface ${Bean}DAO
{
	public List<${Bean}> queryByCondition(Criteria criteria)throws Exception;
	
	public int queryCountByCondition(Criteria criteria)throws Exception;
}
package ${package}.dao;

import java.util.List;

import ${package}.bean.${Bean};
import com.sklay.core.query.Criteria;

public interface ${Bean}DAO
{
	/**
	 * 查询全部数据
	 * @return List<${bean}>
	 * @throws Exception
	 */
	public List<${Bean}> query()throws Exception;
	
	/**
	 * 根据主键查询
	 * @return ${bean}
	 * @throws Exception
	 */
	public ${Bean} queryById(long id)throws Exception;
	
	/**
	 * 插入单个数据
	 * @param ${bean}
	 * @return int
	 * @throws Exception
	 */
	public int insert(${Bean} ${bean})throws Exception;
	
	/**
	 * 插入批量数据
	 * @param ${bean}s
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<${Bean}> ${bean}s)throws Exception;
	
	/**
	 * 更新单个数据
	 * @param ${bean}
	 * @return int
	 * @throws Exception
	 */
	public int update(${Bean} ${bean})throws Exception;
	
	/**
	 * 更新批量数据
	 * @param ${bean}s
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<${Bean}> ${bean}s)throws Exception;
	
	/**
	 * 根据主键删除单个数据
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;
	
	/**
	 * 根据主键删除批量数据
	 * @param id
	 * @throws Exception
	 */
	public void deleteBatch(List<Long> ids)throws Exception;
	
	/**
	 * 按条件查询记录
	 * @param criteria
	 * @throws Exception
	 */
	public List<${Bean}> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * 按条件查询记录条数
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}
<#--
	DAO模板,参数介绍
	package:包路径
	Bean:首字母大写的类名
	bean:首字母小写的类名
-->
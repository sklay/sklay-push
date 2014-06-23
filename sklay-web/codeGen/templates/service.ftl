package ${package}.service;

import java.util.List;

import ${package}.bean.${Bean};
import com.sklay.core.query.Criteria;

public interface I${Bean}SV
{
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ${Bean} queryById(long id)throws Exception;
	
	/**
	 * 添加
	 * @param ${bean}
	 * @return
	 * @throws Exception
	 */
	public ${Bean} save(${Bean} ${bean})throws Exception;
	
	/**
	 * 更新
	 * @param ${bean}
	 * @throws Exception
	 */
	public void update(${Bean} ${bean})throws Exception;
	
	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * 新增或删除
	 * @param ${bean}
	 * @throws Exception
	 */
	public void saveOrUpdate(${Bean} ${bean})throws Exception;

	/**
	 * 新增或删除
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<${Bean}> list)throws Exception;

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

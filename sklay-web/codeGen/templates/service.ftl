package ${package}.service;

import java.util.List;

import ${package}.bean.${Bean};
import com.sklay.core.query.Criteria;

public interface I${Bean}SV
{
	/**
	 * ����������ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ${Bean} queryById(long id)throws Exception;
	
	/**
	 * ���
	 * @param ${bean}
	 * @return
	 * @throws Exception
	 */
	public ${Bean} save(${Bean} ${bean})throws Exception;
	
	/**
	 * ����
	 * @param ${bean}
	 * @throws Exception
	 */
	public void update(${Bean} ${bean})throws Exception;
	
	/**
	 * ����ɾ��
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;

	/**
	 * ������ɾ��
	 * @param ${bean}
	 * @throws Exception
	 */
	public void saveOrUpdate(${Bean} ${bean})throws Exception;

	/**
	 * ������ɾ��
	 * @param list
	 * @throws Exception
	 */
	public void saveOrUpdate(List<${Bean}> list)throws Exception;

	/**
	 * ��������ѯ��¼
	 * @param criteria
	 * @throws Exception
	 */
	public List<${Bean}> queryByCondition(Criteria criteria)throws Exception;
	
	/**
	 * ��������ѯ��¼����
	 * @param criteria
	 * @throws Exception
	 */
	public int queryCountByCondition(Criteria criteria)throws Exception;
}

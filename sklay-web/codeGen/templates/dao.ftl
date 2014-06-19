package ${package}.dao;

import java.util.List;

import ${package}.bean.${Bean};
import com.sklay.core.query.Criteria;

public interface ${Bean}DAO
{
	/**
	 * ��ѯȫ������
	 * @return List<${bean}>
	 * @throws Exception
	 */
	public List<${Bean}> query()throws Exception;
	
	/**
	 * ����������ѯ
	 * @return ${bean}
	 * @throws Exception
	 */
	public ${Bean} queryById(long id)throws Exception;
	
	/**
	 * ���뵥������
	 * @param ${bean}
	 * @return int
	 * @throws Exception
	 */
	public int insert(${Bean} ${bean})throws Exception;
	
	/**
	 * ������������
	 * @param ${bean}s
	 * @return 
	 * @throws Exception
	 */
	public void insertBatch(List<${Bean}> ${bean}s)throws Exception;
	
	/**
	 * ���µ�������
	 * @param ${bean}
	 * @return int
	 * @throws Exception
	 */
	public int update(${Bean} ${bean})throws Exception;
	
	/**
	 * ������������
	 * @param ${bean}s
	 * @return 
	 * @throws Exception
	 */
	public void updateBatch(List<${Bean}> ${bean}s)throws Exception;
	
	/**
	 * ��������ɾ����������
	 * @param id
	 * @throws Exception
	 */
	public void delete(long id)throws Exception;
	
	/**
	 * ��������ɾ����������
	 * @param id
	 * @throws Exception
	 */
	public void deleteBatch(List<Long> ids)throws Exception;
	
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
<#--
	DAOģ��,��������
	package:��·��
	Bean:����ĸ��д������
	bean:����ĸСд������
-->
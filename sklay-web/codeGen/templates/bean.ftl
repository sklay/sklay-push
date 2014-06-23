package ${package}.bean;

import java.io.Serializable;
import java.util.Date;

public class ${Bean} implements Serializable
{
	/**
	 * ����
	 */
	private long id;
	
	/**
	 * ����COL_ID
	 */
	public static final String COL_ID = "ID";

	/**
	 * ��ȡ����
	 */
	public long getId()
	{
		return this.id;
	}
	/**
	 * ��������
	 */
	public void setId(long id)
	{
		this.id = id;
	}
	
	<#list fields as field>
	/**
	 * ����${field.name}
	 */
	private ${field.javaType} ${field.name};
	
	/**
	 * ����COL_${field.col}
	 */
	public static final String COL_${field.col} = "${field.col}";

	/**
	 * ��ȡ${field.name}����
	 */
	public ${field.javaType} get${field.Name}()
	{
		return this.${field.name};
	}
	
	/**
	 * ����${field.name}����
	 */
	public void set${field.Name}(${field.javaType} ${field.name})
	{
		this.${field.name} = ${field.name};
	}
	
	</#list>
}

<#--
	Modelģ��,��������
	package:��·��
	Bean:����ĸ��д������
	fields:���Լ���
		javaType:���Զ�Ӧ��Java����,�������ͼ���Date����
		Name:����ĸ��д��������
		name:����ĸСд��������
-->
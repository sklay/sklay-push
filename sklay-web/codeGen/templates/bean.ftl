package ${package}.bean;

import java.io.Serializable;
import java.util.Date;

public class ${Bean} implements Serializable
{
	/**
	 * 主键
	 */
	private long id;
	
	/**
	 * 常量COL_ID
	 */
	public static final String COL_ID = "ID";

	/**
	 * 获取主键
	 */
	public long getId()
	{
		return this.id;
	}
	/**
	 * 设置主键
	 */
	public void setId(long id)
	{
		this.id = id;
	}
	
	<#list fields as field>
	/**
	 * 属性${field.name}
	 */
	private ${field.javaType} ${field.name};
	
	/**
	 * 常量COL_${field.col}
	 */
	public static final String COL_${field.col} = "${field.col}";

	/**
	 * 获取${field.name}属性
	 */
	public ${field.javaType} get${field.Name}()
	{
		return this.${field.name};
	}
	
	/**
	 * 设置${field.name}属性
	 */
	public void set${field.Name}(${field.javaType} ${field.name})
	{
		this.${field.name} = ${field.name};
	}
	
	</#list>
}

<#--
	Model模板,参数介绍
	package:包路径
	Bean:首字母大写的类名
	fields:属性集合
		javaType:属性对应的Java类型,基本类型加上Date类型
		Name:首字母大写的属性名
		name:首字母小写的属性名
-->
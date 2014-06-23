package ${package}.bean;

import java.io.Serializable;
import java.util.Date;

public class ${Bean} implements Serializable
{
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
	 * 获取COL_${field.Name}参数
	 */
	public ${field.javaType} get${field.Name}()
	{
		return this.${field.name};
	}
	
	/**
	 * 设置${field.Name}参数
	 * @param ${field.Name}
	 */
	public void set${field.Name}(${field.javaType} ${field.name})
	{
		this.${field.name} = ${field.name};
	}
	
	</#list>
}
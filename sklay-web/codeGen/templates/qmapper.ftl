<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="${package}.dao.${Bean}DAO">
	<resultMap type="${package}.bean.${Bean}" id="${bean}Result">
	<#list fields as field>
		<result property="${field.name}" column="${field.col}" javaType="${field.javaType}"/>
	</#list>
	</resultMap>

    <select id="queryByCondition" resultMap="${bean}Result" >
    	SELECT * FROM (${SELECT_SQL}) AS T WHERE 1=1
    	<if test="_CONDITION != null and _CONDITION != ''">
    	${r"${_CONDITION}"} 
    	</if>
    	<if test="_ORDER_BY != null and _ORDER_BY != ''">
    	${r"${_ORDER_BY}"} 
    	</if>
    	<if test="_LIMIT != null and _LIMIT != ''">
    	${r"${_LIMIT}"}
    	</if>
    </select>
    
    <select id="queryCountByCondition" resultType="int">
    	${COUNT_SQL} WHERE 1=1
    	<if test="_CONDITION != null and _CONDITION != ''">
    	${r"${_CONDITION}"} 
    	</if>
    </select> 
</mapper>
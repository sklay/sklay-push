<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="${package}.dao.${Bean}DAO">
	<resultMap type="${package}.bean.${Bean}" id="${bean}Result">
		<id property="id" column="ID" javaType="long" />
	<#list fields as field>
		<result property="${field.name}" column="${field.col}" javaType="${field.javaType}"/>
	</#list>
	</resultMap>
	
	<select id="query" resultMap="${bean}Result">
		SELECT `ID`,${COLS} FROM ${TABLE};
	</select>
	
    <select id="queryById" resultMap="${bean}Result" parameterType="long">
        SELECT `ID`,${COLS} FROM ${TABLE} WHERE ID = ${r"#{id}"};
    </select>
    
    <select id="queryByCondition" resultMap="${bean}Result" >
    	SELECT `ID`,${COLS} FROM ${TABLE} WHERE 1=1 
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
    	SELECT COUNT(*) FROM ${TABLE} WHERE 1=1 
    	<if test="_CONDITION != null and _CONDITION != ''">
    	${r"${_CONDITION}"} 
    	</if>
    </select>
    
    <insert id="insert" parameterType="${package}.bean.${Bean}">
    	<#if auto_increment == "true">
		<selectKey resultType="long" keyProperty="id">
			SELECT LAST_INSERT_ID()
		</selectKey>
    	INSERT INTO ${TABLE}(${COLS}) VALUES (${_COLS});
    	<#else>
    	INSERT INTO ${TABLE}(`ID`,${COLS}) VALUES (${r"#{id}"},${_COLS});
    	</#if>
    </insert>
    
    <insert id="insertBatch">
    	<#if auto_increment == "true">
    	INSERT INTO ${TABLE} ( ${COLS} ) VALUES 
	    <foreach collection="list" item="item" index="index" separator=",">
	        (${ITEM_COLS})
	    </foreach>
	    <#else>
	    INSERT INTO ${TABLE} (`ID`, ${COLS} ) VALUES 
	    <foreach collection="list" item="item" index="index" separator=",">
	        (${r"#{item.id}"},${ITEM_COLS})
	    </foreach>
	    </#if>
    </insert>
    
    <delete id="delete" parameterType="long">
    	DELETE FROM ${TABLE} WHERE `ID` = ${r"#{id}"};
    </delete>
    
    <delete id="deleteBatch">
    	DELETE FROM ${TABLE} WHERE `ID` IN 
    	<foreach collection="list" item="item" index="index" separator="," open="(" close=")">
    		${r"#{item}"}
    	</foreach>
    </delete>
    
    <update id="update" parameterType="${package}.bean.${Bean}">
    	UPDATE ${TABLE} SET ${UPDATE_SQL} WHERE `ID` = ${r"#{id}"}
    </update>
    
    <update id="updateBatch">
    	
    </update>
</mapper>

<#--
	Mapperģ��
	package:��·��
	Bean:����ĸ��д������
	COLS:��ID�ֶ���������ֶ�,ʹ�ö��ŷֿ�
	TABLE:����
	_COLS:����#{code},#{name}��ʽ���ַ�����Ҫ��COLSƥ��
	ITEM_COLS:����#{item.code},#{item.name}
	UPDATE_SQL:����code = #{code},name=#{name}
-->
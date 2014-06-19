package com.sklay.core.query;

import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

/**
 * 查询条件
 * 
 * @author
 * 
 */
public class Criteria extends HashMap<String, Object> implements Serializable
{
    private static final long serialVersionUID = 214497609198950550L;
    
    private StringBuffer condition = new StringBuffer();
    
    private StringBuffer orderBy = new StringBuffer();
    
    private StringBuffer limit = new StringBuffer();
    
    private static long seq = 0L;
    
    public static synchronized long getSeq()
    {
        if (seq >= Long.MAX_VALUE - 10000)
        {
            seq = 0L;
        }
        return seq++;
    }
    
    public Criteria()
    {
        put("_CONDITION", condition);
        put("_ORDER_BY", orderBy);
        put("_LIMIT", limit);
    }
    
    public Criteria addParam(String col, Object value)
    {
        put(col.toUpperCase(), value);
        return this;
    }
    
    public Criteria addEqual(String col, Object value)
    {
        String paramName = "PARAM_" + getSeq();
        condition.append(" AND `").append(col).append("` = #{").append(paramName).append("}");
        put(paramName, value);
        return this;
    }
    
    public Criteria addLess(String col, Object value)
    {
        String paramName = "PARAM_" + getSeq();
        condition.append(" AND `").append(col).append("` < #{").append(paramName).append("}");
        put(paramName, value);
        return this;
    }
    
    public Criteria addLarge(String col, Object value)
    {
        String paramName = "PARAM_" + getSeq();
        condition.append(" AND `").append(col).append("` > #{").append(paramName).append("}");
        put(paramName, value);
        return this;
    }
    
    public Criteria addLessEqual(String col, Object value)
    {
        String paramName = "PARAM_" + getSeq();
        condition.append(" AND `").append(col).append("` <= #{").append(paramName).append("}");
        put(paramName, value);
        return this;
    }
    
    public Criteria addLargeEqual(String col, Object value)
    {
        String paramName = "PARAM_" + getSeq();
        condition.append(" AND `").append(col).append("` >= #{").append(paramName).append("}");
        put(paramName, value);
        return this;
    }
    
    public Criteria addLike(String col, Object value)
    {
        String paramName = "PARAM_" + getSeq();
        condition.append(" AND `").append(col).append("` LIKE #{").append(paramName).append("}");
        put(paramName, value);
        return this;
    }
    
    public Criteria addNotEqual(String col, Object value)
    {
        String paramName = "PARAM_" + getSeq();
        condition.append(" AND `").append(col).append("` != #{").append(paramName).append("}");
        put(paramName, value);
        return this;
    }
    
    public Criteria addNotLike(String col, Object value)
    {
        String paramName = "PARAM_" + getSeq();
        condition.append(" AND `").append(col).append("` NOT LIKE #{").append(paramName).append("}");
        put(paramName, value);
        return this;
    }
    
    public Criteria addIn(String col, String value)
    {
        condition.append(" AND `").append(col).append("` IN(").append(value).append(")");
        return this;
    }
    
    public Criteria addNotIn(String col, String value)
    {
        condition.append(" AND `").append(col).append("` NOT IN(").append(value).append(")");
        return this;
    }
    
    public Criteria addNull(String col)
    {
        condition.append(" AND `").append(col).append("` IS NULL ");
        return this;
    }
    
    public Criteria addNotNull(String col)
    {
        condition.append(" AND `").append(col).append("` IS NOT NULL ");
        return this;
    }
    
    public Criteria orderBy(String cols)
    {
        orderBy.append(" ORDER BY ").append(cols);
        return this;
    }
    
    public Criteria setOrderBy(String orderByStr)
    {
        if (!StringUtils.isBlank(orderByStr))
        {
            orderBy.append(" ORDER BY ").append(orderByStr);
        }
        return this;
    }
    
    public Criteria limit(int start, int size)
    {
        limit.append(" LIMIT ").append(start).append(",").append(size);
        return this;
    }
    
    public Criteria and(Criteria criteria)
    {
        condition.append(" AND ( ").append(criteria.condition).append(") ");
        putAll(criteria);
        return this;
    }
    
    public Criteria or(Criteria criteria)
    {
        condition.append(" OR ( ").append(criteria.condition).append(") ");
        putAll(criteria);
        return this;
    }
    
    public Criteria addRegexp(String col, String regexp)
    {
        condition.append(" AND `").append(col).append("` REGEXP ('").append(regexp).append("')");
        return this;
    }
}

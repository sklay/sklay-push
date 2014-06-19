package com.sklay.core.query;

import org.apache.commons.lang.StringUtils;

/**
 * 分页对象
 * 
 * @version: v1.0.0
 * @author: mengbin
 * @date: 2013年12月2日下午1:33:25
 */
public class Pagination
{
    private Criteria criteria;
    
    private int total;
    
    private int pageIndex = 0;
    
    private int pageSize = DEFAULT_PAGE_SIZE;
    
    private int pages;
    
    private String orderBy;
    
    public static final int DEFAULT_PAGE_SIZE = 10;
    
    public static final String PAGINATION_NAME = "pagination";
    
    public void setCriteria(Criteria criteria)
    {
        this.criteria = criteria;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public int getPageIndex()
    {
        return pageIndex;
    }
    
    public void setPageIndex(int pageIndex)
    {
        this.pageIndex = pageIndex;
    }
    
    public int getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public int getPages()
    {
        if (pageSize != 0)
        {
            if (total % pageSize == 0)
            {
                this.pages = total / pageSize;
            }
            else
            {
                this.pages = total / pageSize + 1;
            }
        }
        return pages;
    }
    
    public String getOrderBy()
    {
        return orderBy;
    }
    
    public void setOrderBy(String orderBy)
    {
        this.orderBy = orderBy;
    }
    
    public Criteria criteria()
    {
        if (total % pageSize == 0)
        {
            this.pages = total / pageSize;
        }
        else
        {
            this.pages = total / pageSize + 1;
        }
        this.criteria.limit(pageIndex * pageSize, pageSize);
        if (!StringUtils.isBlank(orderBy))
        {
            this.criteria.setOrderBy(orderBy);
        }
        return this.criteria;
    }
}

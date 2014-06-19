package com.sklay.entity;

import java.io.Serializable;

public class User implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 6239544499423560948L;
    
    private String userName;
    
    private String password;
    
    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }
    
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
}

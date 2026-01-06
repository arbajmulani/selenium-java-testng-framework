package com.arbaj.automation.models;

public class LoginData {

    private String username;
    private String password;
    private String expectedMessage;


    // ✅ Used by Excel 
    public LoginData(String username, String password, String expectedMessage) 
    {
        this.username = username;
        this.password = password;
        this.expectedMessage = expectedMessage;
    }

    public String getUsername() 
    {
        return username;
    }

    public String getPassword() 
    {
        return password;
    }

    public String getExpectedMessage() 
    {
        return expectedMessage;
    }


    
    // ✅ REQUIRED for JSON 
    public LoginData() {}
    
    public void setUsername(String username) 
    {   
        this.username = username;
    }
    
    public void setPassword(String password) 
    {   
        this.password = password;
    }
    
    public void setExpectedMessage(String expectedMessage) 
    { 
        this.expectedMessage = expectedMessage;
    }
}

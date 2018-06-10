package com.leviticus.foodd;

public class User
{
    Inventory inventory;
    String UserName;
    String EmailAddress;
    public String GetEmailAddress()
    {
        return EmailAddress;
    }
    public String GetUserName()
    {
        return UserName;
    }
    User(String _UserName, String _EmailAddress)
    {
        UserName = _UserName;
        EmailAddress = _EmailAddress;
    }
}

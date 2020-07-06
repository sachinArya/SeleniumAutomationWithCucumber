package com.automation;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookieHandler {

    public String getCookieValue(WebDriver driver, String cookieName) throws Exception
    {
        String cookieValue= "";

        if(driver.manage().getCookieNamed(cookieName)!= null)
            cookieValue = driver.manage().getCookieNamed(cookieName).getValue();

        return cookieValue;
    }

    public Cookie getCookieByName(WebDriver driver, String cookieName) throws Exception
    {
        return driver.manage().getCookieNamed(cookieName);
    }

    public Cookie getCookieByValue(WebDriver driver, String cookieValue) throws Exception
    {
        Cookie cookieToBeSearched = null;
        Set<Cookie> cookies = driver.manage().getCookies();

        for(Cookie cookie:cookies)
        {
            if(cookie.getValue().equals(cookieValue))
            {
                cookieToBeSearched = cookie;
                break;
            }
        }

        return cookieToBeSearched;
    }

    public void addCookie(WebDriver driver, String cookieName, String cookieValue) throws Exception
    {
        Cookie cookie = new Cookie(cookieName,cookieValue);
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(WebDriver driver, String cookieName) throws Exception
    {
        driver.manage().deleteCookieNamed(cookieName);
    }

}

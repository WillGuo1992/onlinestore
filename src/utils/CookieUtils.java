package utils;

import javax.servlet.http.Cookie;

/**
 * @description: Cookie工具类
 * @author: Will.Guo
 * @create: 2018-06-13 00:52
 **/
public class CookieUtils {
    static public Cookie getCookie(String cookieName ,Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName()==cookieName){
                return cookie;
            }
        }
        return null;
    }
}

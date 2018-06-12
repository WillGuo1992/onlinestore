package utils;

import java.util.UUID;

/**
 * @description: 生成32位16进制数的UUID
 * @author: Will.Guo
 * @create: 2018-06-10 16:09
 **/
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    public static String get64UUID(){
        return getUUID()+getUUID();
    }
}

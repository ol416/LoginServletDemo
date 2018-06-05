package cn.ol.demo.util;

import java.util.UUID;

public class ActiveUserCodeUtil {
    public static String createActiveUserCode(){
        return UUID.randomUUID().toString();
    }
}

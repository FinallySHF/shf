package com.shf.shf.core.util;

import java.util.UUID;

/**
 * <p><b>生成ID工具类 </b></p>
 * @author Chao.yy #2018年3月13日 下午6:05:19 
 * @version V1.0
 */
public class IDUtils {

    /**
     * 
     * <p><b>使用UUID生成随机ID,无分隔符</b></p>
     * @author Chao.yy #2018年3月13日 下午6:04:52 
     * @version V1.0
     * @return UUID去除分隔符的字符串
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

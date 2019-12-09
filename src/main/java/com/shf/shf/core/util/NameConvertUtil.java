package com.shf.shf.core.util;

/**
 * <p><b>名称转换工具类</b></p>
 * @author Chao.yy  #2018年10月29日 上午11:25:18
 * @version V1.0.4
 * 
 */
public class NameConvertUtil {

	/**
	 * 
	 * <p><b>数据库列名转方法名 类似 user_name 变为 userName</b></p>
	 * @author Chao.yy  # 2018年10月29日 上午11:28:28
	 * @version V1.0.6
	 * @param str
	 * @return
	 *
	 */
    public static String columName2MethodName(String str) {
        if (str == null || str.trim().length() < 1) {
            return null;
        }
        String[] split = str.toLowerCase().split("_");
        String retString = "";
        int i = 1;
        retString += split[0];
        while (i < split.length) {
            String string = split[i];
            if (string.length() > 1) {
                retString += string.substring(0, 1).toUpperCase() + string.substring(1);
            } else {
                retString += string;
            }
            i++;
        }
        return retString;
    }
}

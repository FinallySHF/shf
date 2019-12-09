package com.shf.shf.core.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p><b>获取泛型类型</b></p>
 * @author Chao.yy  #2018年06月04日 上午10:13:54
 * @version V1.0
 * 
 */
public class GetGenericUtil {
    /**
     * 
     * <p><b>获取类中泛型参数的类型</b></p>
     * @author Chao.yy  # 2018年06月04日 上午10:19:27
     * @version V1.0
     * @param clazz 
     * @param index 参数索引
     * @return
     *
     */
    @SuppressWarnings("rawtypes")
    public static Class getClass(Class clazz, int index) {
        Type type = clazz.getGenericSuperclass();
        // 判断 是否泛型
        if (type instanceof ParameterizedType) {
            // 返回表示此类型实际类型参数的Type对象的数组.
            // 当有多个泛型类时，数组的长度就不是1了
            Type[] ptype = ((ParameterizedType) type).getActualTypeArguments();
            //将索引位置泛型T对应的类返回
            try {
                return (Class) ptype[index];
            }catch (Exception e) {
                return Object.class;
            }
        } else {
            //若没有给定泛型，则返回Object类
            return Object.class;
        }
    }
    
    /**
     * 
     * <p><b>通过Class获取泛型参数类型的对象实例</b></p>
     * @author Chao.yy  # 2018年09月06日 上午10:23:45
     * @version V1.0
     * @param clazz
     * @param index 参数索引
     * @return
     *
     */
    @SuppressWarnings("rawtypes")
    public static Object getInstance(Class clazz, int index) {
        Class clazz1 = getClass(clazz, index);
        Object obj;
        try {
            obj = clazz1.newInstance();
        } catch (Exception e) {
            //如实例化失败直接返回Object类型对象
            obj = new Object();
        }  
        return obj;
    }

}

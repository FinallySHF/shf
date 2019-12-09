package com.shf.shf.core.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p><b>多数据源key存取容器</b></p>
 * @author Chao.yy  #2018年06月07日 下午4:22:46
 * @version V1.0
 *
 */
public class MultipleDataSourceContextHolder {

    private MultipleDataSourceContextHolder() {
		super();
 	}

	/**
     * 为本线程维护变量，以避免线程间影响
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "default";
        }
    };

    /**
     * 存储当前所有数据源Key
     */
    private static List<Object>  dataSourceKeys = new ArrayList<Object>();

    /**
     * 
     * <p><b>设置当前数据源Key</b></p>
     * @author Chao.yy  # 2018年06月07日 下午4:30:28
     * @version V1.0
     * @param key
     *
     */
    public static void setDataSourceKey(String key) {
        CONTEXT_HOLDER.set(key);
    }

    /**
     * 
     * <p><b>获取当前数据源Key</b></p>
     * @author Chao.yy  # 2018年06月07日 下午4:30:53
     * @version V1.0
     * @return
     *
     */
    public static String getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 
     * <p><b>重置为默认数据源</b></p>
     * @author Chao.yy  # 2018年06月11日 上午11:42:55
     * @version V1.0
     *
     */
    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 
     * <p><b>检查给定Key是否有对应数据源</b></p>
     * @author Chao.yy  # 2018年06月07日 下午4:31:41
     * @version V1.0
     * @param key 数据库key
     * @return
     *
     */
    public static boolean containDataSourceKey(String key) {
        return getDataSourceKeys().contains(key);
    }

	public static List<Object> getDataSourceKeys() {
		return dataSourceKeys;
	}

	public static void setDataSourceKeys(List<Object> dataSourceKeys) {
		MultipleDataSourceContextHolder.dataSourceKeys = dataSourceKeys;
	}
}

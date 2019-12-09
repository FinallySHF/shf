package com.shf.shf.core.domain;

import java.util.HashMap;
import java.util.List;

/**
 * echart 条形框
 * key是 x轴的数据
 * value是数据，目前为单数据源。
 * 
 * @author liudonghe
 * @date 2017年5月16日 下午6:16:38 
 *
 */
public class Bar extends HashMap<String, List<Object>>{

    private static final long serialVersionUID = 1L;
    
    public static final String KEY = "name";
    public static final String VALUE = "value";
    
}

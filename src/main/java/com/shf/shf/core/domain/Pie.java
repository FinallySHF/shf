package com.shf.shf.core.domain;

import java.util.List;

/**
 * 饼图实体
 * @author liudonghe    2017年6月12日 上午10:20:57
 */
public class Pie {
    
    public static final String KEY = "name";
    
    private List<String> keys;
    private List<?> values;

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public List<?> getValues() {
        return values;
    }

    public void setValues(List<?> values) {
        this.values = values;
    }

    

}

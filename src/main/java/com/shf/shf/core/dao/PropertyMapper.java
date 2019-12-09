package com.shf.shf.core.dao;

/**
 * <p><b>实体类属性与数据库列映射接口</b></p>
 * @author Chao.yy  #2018年06月02日 下午11:06:44
 * @version V1.0
 * 
 */
public interface PropertyMapper {
    /**
     * 
     * <p><b>获取指定字段数据库映射列名</b></p>
     * @author Chao.yy  # 2018年06月02日 下午11:07:11
     * @version V1.0
     * @param property 属性名
     * @return 列名
     *
     */
    String getPropertyMapper(String property);
}

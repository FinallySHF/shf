package com.shf.shf.core.datasource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p><b>数据源切换选择注解</b></p>
 * @author Chao.yy  #2018年06月07日 下午2:53:59
 * @version V1.0
 * 
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DataSource {
    String value();
}

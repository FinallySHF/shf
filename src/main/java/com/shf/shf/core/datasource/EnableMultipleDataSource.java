package com.shf.shf.core.datasource;
 
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;


/**
 * 
 * <p><b>启用多数据源配置</b></p>
 * @author Chao.yy  #2018年09月20日 下午2:30:09
 * @version V1.0.1
 *
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({MultipleDataSourceConfigurer.class,DataSourceProperties.class,DynamicDataSourceAspect.class})
public @interface EnableMultipleDataSource
{
}

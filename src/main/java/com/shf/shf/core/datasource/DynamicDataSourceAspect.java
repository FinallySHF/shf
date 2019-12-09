package com.shf.shf.core.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p><b>动态数据源切换时机切面</b></p>
 * @author Chao.yy  #2018年06月07日 下午2:56:04
 * @version V1.0
 *
 */
@Aspect
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     * 
     * <p><b>切换数据源</b></p>
     * @author Chao.yy  # 2018年06月07日 下午2:58:45
     * @version V1.0
     * @param point  
     * @param dataSource  
     *
     */
    @Before("@annotation(dataSource))")
    public void switchDataSource(JoinPoint point, DataSource dataSource) {
    	  logger.debug("当前数据源： [{}] ,目标数据源： [{}]",
                  MultipleDataSourceContextHolder.getDataSourceKey(), dataSource.value());
    	if (!MultipleDataSourceContextHolder.containDataSourceKey(dataSource.value())) {
            logger.error("数据源： [{}] 不存在, 使用默认数据源", dataSource.value());
        } else {
            MultipleDataSourceContextHolder.setDataSourceKey(dataSource.value());
            logger.debug("数据源切换： [{}] ,调用位置： [{}]",
                MultipleDataSourceContextHolder.getDataSourceKey(), point.getSignature());
        }
    }

    
    /**
     * 
     * <p><b>重置为默认数据源</b></p>
     * @author Chao.yy  # 2018年06月07日 下午3:06:32
     * @version V1.0
     * @param point
     * @param dataSource
     *
     */
    @After("@annotation(dataSource))")
    public void restoreDataSource(JoinPoint point, DataSource dataSource) {
        MultipleDataSourceContextHolder.clearDataSourceKey();
        logger.info("数据源重置： [{}] ,调用位置： [{}]",
            MultipleDataSourceContextHolder.getDataSourceKey(), point.getSignature());
    }
}

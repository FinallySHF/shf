package com.shf.shf.core.datasource;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p><b>动态路由数据源</b></p>
 * @author Chao.yy  #2018年06月07日 下午3:10:20
 * @version V1.0
 * 
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 数据源map key是数据源名称，value是数据源对象
     */
    private Map<Object, Object> dataSourceMap;
    


	/**
     * 动态设置应用数据源 
     */
    @Override
    protected Object determineCurrentLookupKey() {
        logger.debug("当前数据源 [{}]", MultipleDataSourceContextHolder.getDataSourceKey());
        return MultipleDataSourceContextHolder.getDataSourceKey();
    }

 
	public Map<Object, Object> getDataSourceMap() {
		return dataSourceMap;
	}


	public void setDataSourceMap(Map<Object, Object> dataSourceMap) {
		this.dataSourceMap = dataSourceMap;
		logger.debug("数据源初始化完成 [{}]", dataSourceMap.size());
	}
    
    
}
